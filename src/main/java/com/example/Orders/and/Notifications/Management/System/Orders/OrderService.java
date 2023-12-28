package com.example.Orders.and.Notifications.Management.System.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    OrderRepository orderRepository;
    @Autowired
    OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    public Order addOrder(Order order){
        //we have list of cart items in order
        //loop on this list
        //for each item in it call get productByID productcontroller
        //then call Updatequantity from productcontroller
        //

        return orderRepository.saveOrder(order);
    }
    public void getAllOrders(){
        orderRepository.getOrders();
    }
    public void getOrderByID(Long id){
        orderRepository.getOrderByID(id);
    }


}
