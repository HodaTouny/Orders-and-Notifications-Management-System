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
        orders.add(order);
        for (Order i : orders){
            System.out.println(i+"-");
        }
        return order;
    }
    public List<Order> getOrders(){
       for (Order i : orders){
           System.out.println(i+" ;;");
       }
        return orders;
    }

    public Order getOrderByID(Long ID){
     return null;
    }

    @Override
    public Order deletedOrder(Long ID) {
        Order order = getOrderByID(ID);
        orders.remove(order);
        return order;
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
