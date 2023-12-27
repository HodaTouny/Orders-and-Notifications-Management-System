package com.example.Orders.and.Notifications.Management.System.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleOrderRepository
{
    List<Order> orders;
    SimpleOrderRepository (){
        orders = new ArrayList<>();
    }

    public Order saveOrder(Order order) {
        orders.add(order);
        return order;
    }
    public List<Order> getOrders(){
        return orders;
    }
}
