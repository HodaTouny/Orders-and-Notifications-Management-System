package com.example.Orders.and.Notifications.Management.System.Orders;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Repository
public class OrderRepository {
    List<Order> orders;
   OrderRepository (){
        orders = new ArrayList<>();
    }

    public Order saveOrder(Order order) {
        orders.add(order);
        return order;
    }
    public List<Order> getOrders(){
        return orders;
    }
    public Order getOrderByID(Long ID){
       for(Order order:orders){
           if(Objects.equals(order.id, ID)) {
               return order;
           }
       }
       return null;
    }
}
