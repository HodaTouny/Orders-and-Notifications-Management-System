package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Notifications.*;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Service
public class SimpleOrderService extends IService {
    private final NotificationFactoryImpl notificationFactory;
    private final NotificationController notificationController;

    public SimpleOrderService(OrderRepository orderRepository, ProductService productService, CustomerService customerService, NotificationFactoryImpl notificationFactory, NotificationController notificationController){
        super(orderRepository, customerService, productService);
        this.notificationFactory = notificationFactory;
        this.notificationController = notificationController;
    }

    public void placeSimpleOrder(Order order){
        Long toBeDecreased = (long) (((SimpleOrder)order).getPrice());
        Vector<Pair<Product,Integer>> allProducts = ((SimpleOrder)order).getOrderProducts();
        customerService.decreaseBalance(((SimpleOrder)order).getCustomer().getId(), toBeDecreased) ;
        for (Pair<Product, Integer> prod : allProducts) {
            productService.updateQuantity(prod.getKey().getSerialNumber(),prod.getValue());
        }
    }
    @Override
    public boolean placeOrder(Order order) {
        long fees = (long) calculateFees(((SimpleOrder)order).getPrice());
        NotificationTemplate noticationTemplate = notificationFactory.createNotification("order");
//        List<Channel> channels = new ArrayList<>();
//        channels.add(new SMS());
        if(CheckOrderAvailability(order)) {
            customerService.decreaseBalance(((SimpleOrder) order).getCustomer().getId(), fees);
            placeSimpleOrder(order);
            order.setShippingFees(fees);
            orderRepository.saveOrder(order);
            Notification notification = new Notification((SimpleOrder) order,noticationTemplate);
            notificationController.saveNotification(notification);
                return true;

        }
        return false;
    }
    @Override
    public double calculateFees(int price) {
        return (0.10)*price;
    }
    @Override
    public boolean CheckOrderAvailability(Order order){
        long balance = (long) (((SimpleOrder) order).getPrice() + calculateFees(((SimpleOrder)order).getPrice()));
        Vector<Pair<Product,Integer>> allProducts = ((SimpleOrder)order).getOrderProducts();
        return productService.checkAllProductsAvailability(allProducts) &&
                customerService.balanceAvailability(((SimpleOrder) order).getCustomer().getId(),balance);
    }


}