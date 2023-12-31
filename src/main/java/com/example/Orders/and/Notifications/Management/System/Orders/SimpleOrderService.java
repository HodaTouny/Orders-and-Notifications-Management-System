package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Notifications.*;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class SimpleOrderService extends IService {

    public SimpleOrderService(OrderRepository orderRepository, ProductService productService, CustomerService customerService, NotificationTempFactoryImpl notificationFactory, NotificationController notificationController){
        super(orderRepository, customerService, productService, notificationFactory, notificationController);
    }
    public int calculateOrderPrice(Order order){
        Vector<Pair<Product,Integer>> allProducts = ((SimpleOrder)order).getOrderProducts();
        double price = 0L;
        for (Pair<Product, Integer> prod : allProducts) {
            price+=(prod.getKey().getPrice()*prod.getValue());
        }
        return (int) price;

    }


    public void placeSimpleOrder(Order order){
        Vector<Pair<Product,Integer>> allProducts = ((SimpleOrder)order).getOrderProducts();
        int price = calculateOrderPrice(order);
        ((SimpleOrder) order).setPrice((int) price);
        Long toBeDecreased = (long) (((SimpleOrder)order).getPrice());
        customerService.decreaseBalance(((SimpleOrder)order).getCustomer().getId(), toBeDecreased) ;
        NotificationTemplate notificationTemplate = notificationFactory.createNotification("order");
        Notification notification = new Notification((SimpleOrder) order,((SimpleOrder) order).getChannels(),notificationTemplate);
        notificationController.saveNotification(notification);
        for (Pair<Product, Integer> prod : allProducts) {
            productService.updateQuantity(prod.getKey().getSerialNumber(),prod.getValue());
        }
    }
    @Override
    public boolean placeOrder(Order order) {
        long fees = (long) calculateFees(((SimpleOrder)order).getPrice());
        if(CheckOrderAvailability(order)) {
            customerService.decreaseBalance(((SimpleOrder) order).getCustomer().getId(), fees);
            placeSimpleOrder(order);
            order.setShippingFees(fees);
            orderRepository.saveOrder(order);
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