package com.example.Orders.and.Notifications.Management.System.Orders;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImp implements OrderRepository{
    List<Order> orders;
   OrderRepositoryImp(){
       orders = new ArrayList<>();
    }

    public Order saveOrder(Order order) {
        System.out.println(orders.size());
        orders.add(order);
        System.out.println(orders.size());
        return order;
    }
    public List<Order> getOrders(){
        return orders;
    }

    public Order getOrderByID(Long ID){
     return null;
    }

    @Override
    public Order deletedOrder(Long ID) {
        for (Order order : orders) {
            if (order.getId().equals(ID)) {
                return order;
            }
        }
        return null;
    }

//    @Override
    public Order cancelShipping(Long ID) {;
        for (Order order : orders) {
            if (order.getId().equals(ID)) {
                order.setShippingDate(null);
                return order;
            }
        }
        return null;
    }
}
