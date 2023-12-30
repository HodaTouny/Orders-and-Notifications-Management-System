package com.example.Orders.and.Notifications.Management.System.Orders;
import org.springframework.stereotype.Component;
@Component
public interface FactoryOrder {
    IService create(Order order);
}
