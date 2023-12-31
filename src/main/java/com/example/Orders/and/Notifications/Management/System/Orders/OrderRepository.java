package com.example.Orders.and.Notifications.Management.System.Orders;

import java.util.List;

public interface OrderRepository {
    Order saveOrder(Order order);
    List<Order> getOrders();
    Order getOrderByID(Long ID);
    Order deletedOrder(Long ID);
    Order cancelShipping(Long ID);
    void ChangeStatus(Order order, String status);

}
