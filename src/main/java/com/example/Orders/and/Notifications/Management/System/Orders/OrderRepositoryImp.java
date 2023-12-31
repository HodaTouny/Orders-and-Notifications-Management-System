package com.example.Orders.and.Notifications.Management.System.Orders;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class OrderRepositoryImp implements OrderRepository{
    List<Order> orders;
   OrderRepositoryImp(){
       orders = new ArrayList<>();
    }

    public Order saveOrder(Order order) {
       order.setStatus("Placed");
        orders.add(order);
        return order;
    }
    public List<Order> getOrders(){
        return orders;
    }

    public Order getOrderByID(Long ID){
       for(Order order : orders){
           if(Objects.equals(order.getId(), ID)){
               return order;
           }
       }
       return null;
    }

    @Override
    public Order deletedOrder(Long ID) {
        for (Order order : orders) {
            if (order.getId().equals(ID)) {
                orders.remove(order);
                return order;
            }
        }
        return null;
    }
    @Override
    public Order cancelShipping(Long ID) {;
        for (Order order : orders) {
            if (order.getId().equals(ID)) {
                order.setShippingDate(null);
                order.setShippingFees(0);
                return order;
            }
        }
        return null;
    }
    @Override
    public void ChangeStatus(Order order, String status) {
        for (Order order1 : orders) {
            if (order1.getId().equals(order.getId())) {
                order1.setStatus(status);
            }
        }
    }
}