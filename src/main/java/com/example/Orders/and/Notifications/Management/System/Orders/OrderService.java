package com.example.Orders.and.Notifications.Management.System.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    OrderRepositoryImp orderRepository;
    ManagerFactory managerFactory = new ManagerFactoryImp();
    @Autowired
    OrderService(OrderRepositoryImp orderRepository){
        this.orderRepository = orderRepository;

    }
    public boolean addOrder(Order order){
        OrderManager orderManager = managerFactory.createManagerInstance(order.getOrderType());
        if(orderManager.confirmOrder(order)) {
            orderRepository.saveOrder(order);
            return true;
        }
        return false;
    }
    public List<Order> getAllOrders(){
        return orderRepository.getOrders();
    }
    public void getOrderByID(Long id){
        orderRepository.getOrderByID(id);
    }
    public boolean cancelOrder(Order order){
        OrderManager orderManager = managerFactory.createManagerInstance(order.getOrderType());
        if(orderManager.cancelOrder(order)){
            orderRepository.deletedOrder(order.getId());
            return true;
        }
        return false;

    }
    public boolean cancelShipping(Order order){
        OrderManager orderManager = managerFactory.createManagerInstance(order.getOrderType());
        if(orderManager.cancelOrderShipping(order)) {
            orderRepository.cancelShipping(order.getId());
            return true;
        }
        return false;
    }
}
