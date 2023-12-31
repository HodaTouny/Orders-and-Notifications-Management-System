package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Notifications.NotificationController;
import com.example.Orders.and.Notifications.Management.System.Notifications.NotificationTempFactoryImpl;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class CompoundOrderService extends IService{
    SimpleOrderService simpleOrderService;

    @Autowired
    public CompoundOrderService(OrderRepository orderRepository, SimpleOrderService simpleOrderService, CustomerService customerService,
                                ProductService productService, NotificationTempFactoryImpl notificationFactory,
                                NotificationController notificationController) {
        super(orderRepository, customerService, productService, notificationFactory, notificationController);
        this.simpleOrderService = simpleOrderService;
    }

    @Override
    public boolean placeOrder(Order order) {
        long totalFees =0;
        CompoundOrder compoundOrder = (CompoundOrder) order;
        if(CheckOrderAvailability(order)){
            for (SimpleOrder subOrder : compoundOrder.getCompoundOrder()){
                long fees = (long) calculateFees(subOrder.getPrice());
                customerService.decreaseBalance(subOrder.getCustomer().getId(), fees);
                subOrder.setShippingFees(fees);
                simpleOrderService.placeSimpleOrder(subOrder);
                totalFees+=fees;
            }
            order.setShippingFees(totalFees);
            orderRepository.saveOrder(order);
            return true;
        }
        return false;
    }

    @Override
    public double calculateFees(int price) {
        return (0.05)*price;
    }

    @Override
    public boolean CheckOrderAvailability(Order order) {
        CompoundOrder compoundOrder = (CompoundOrder) order;
        for (SimpleOrder subOrder : compoundOrder.getCompoundOrder()) {
            long balance = (long) (subOrder.getPrice() + calculateFees(subOrder.getPrice()));
            Vector<Pair<Product,Integer>> allProducts = subOrder.getOrderProducts();
            if(!productService.checkAllProductsAvailability(allProducts) &&customerService.balanceAvailability(subOrder.getCustomer().getId(),balance)){
                return false;
            }
        }
        return true;
    }

}
