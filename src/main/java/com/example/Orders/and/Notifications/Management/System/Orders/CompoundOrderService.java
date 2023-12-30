package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompoundOrderService extends IService{
    SimpleOrderService simpleOrderService;
    @Autowired
    public CompoundOrderService(OrderRepositoryImp orderRepository, SimpleOrderService simpleOrderService) {
        super(orderRepository);
        this.simpleOrderService = simpleOrderService;
    }

    @Override
    public boolean placeOrder(Order order) {
        CompoundOrder compoundOrder = (CompoundOrder) order;
        for (Order subOrder : compoundOrder.getCompoundOrder()) {
            boolean subOrderPlaced = simpleOrderService.placeOrder((SimpleOrder)subOrder);
            if (!subOrderPlaced) {
                return false;
            }
        }
        return true;
    }

}
