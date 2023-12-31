package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Notifications.*;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Vector;


@Service
public abstract class IService {
    OrderRepository orderRepository;
    CustomerService customerService;
    ProductService productService;
    NotificationTempFactoryImpl notificationFactory;
    NotificationController notificationController;
    @Autowired
    public IService(OrderRepository orderRepository, CustomerService customerService, ProductService productService, NotificationTempFactoryImpl notificationFactory, NotificationController notificationController) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.notificationFactory = notificationFactory;
        this.notificationController = notificationController;
    }

    public List<Order> getAllOrders(){
        return orderRepository.getOrders();
    }
    public Order getOrderByID(Long id){
        return orderRepository.getOrderByID(id);
    }
    public abstract boolean placeOrder(Order order);
    public boolean deletedOrder(Long orderId) {
        Order order = getOrderByID(orderId);
        if(order !=null) {
            returnBalance(order);
            returnProducts(order);
            orderRepository.deletedOrder(orderId);
            return true;
        }
        return false;
    }
    public boolean cancelShipping(Long id) {
        List<Order> orders = getAllOrders();
        System.out.println(orders.size());
        Order order = getOrderByID(id);
        if(order != null) {
            LocalDate currentDate = LocalDate.now();
            if (order.getShippingDate().isAfter(currentDate)) {
                long hoursUntilShipping = ChronoUnit.HOURS.between(LocalDateTime.now(), order.getShippingDate().atStartOfDay());
                if (hoursUntilShipping >= 24) {
                    returnShipping(order);
                    orderRepository.cancelShipping(id);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    public void returnShipping(Order order) {
        if (order instanceof SimpleOrder) {
            Customer customer = ((SimpleOrder) order).getCustomer();
            if (customer != null) {
                customerService.increaseBalance(customer.getId(), order.getShippingFees());
            }
        } else if (order instanceof CompoundOrder) {
            for (SimpleOrder subOrder : ((CompoundOrder) order).getCompoundOrder()) {
                returnShipping(subOrder);
            }
        }
    }

    public void returnBalance(Order order) {
        if (order instanceof SimpleOrder) {
            Customer customer = ((SimpleOrder) order).getCustomer();
            if (customer != null) {
                customerService.increaseBalance(customer.getId(), order.getShippingFees()+((SimpleOrder) order).getPrice());
            }
        } else if (order instanceof CompoundOrder) {
            for (SimpleOrder subOrder : ((CompoundOrder) order).getCompoundOrder()) {
                returnBalance(subOrder);
            }
        }
    }

    public void returnProducts(Order order) {
        if (order instanceof SimpleOrder) {
            Vector<Pair<Product,Integer>> products = ((SimpleOrder) order).getOrderProducts();
            for(Pair<Product,Integer> product : products){
                productService.increaseQuantity(product.getKey().getSerialNumber(),product.getValue());
            }
        } else if (order instanceof CompoundOrder) {
            for (SimpleOrder subOrder : ((CompoundOrder) order).getCompoundOrder()) {
                returnProducts(subOrder);
            }
        }
    }
    @Scheduled(fixedRate = 5000)
    public void shipOrder(){
        List<Order> orders = orderRepository.getOrders();
        for(Order order : orders){
            if(order.getShippingDate() != null && order.getStatus().equals("placed")){
                LocalDate currentDate = LocalDate.now();
                if(order.getShippingDate().isAfter(currentDate) || order.getShippingDate().isEqual(currentDate)){
                    System.out.println(order.getShippingDate());
                    orderRepository.ChangeStatus(order,"shipped");
                    NotificationTemplate noticationTemplate = notificationFactory.createNotification("shipment");
                    Notification notification = new Notification( (SimpleOrder)order,((SimpleOrder) order).getChannels(),noticationTemplate);
                    notificationController.saveNotification(notification);

                }
            }
        }
    }


    public abstract double calculateFees(int price);

    public abstract boolean CheckOrderAvailability(Order order);

}
