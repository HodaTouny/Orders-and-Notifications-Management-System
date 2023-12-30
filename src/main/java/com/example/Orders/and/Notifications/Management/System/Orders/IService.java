package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;



@Service
public abstract class IService {
    OrderRepositoryImp orderRepository;
    public IService(OrderRepositoryImp orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order> getAllOrders(){
        return orderRepository.getOrders();
    }
    public Order getOrderByID(Long id){
        return orderRepository.getOrderByID(id);
    }
    public abstract boolean placeOrder(Order order);

    public boolean deletedOrder(Long orderId) {
        Order order  = orderRepository.deletedOrder(orderId);
        if (order != null) {
           return true;
        }
        return false;
    }

    public boolean cancelShipping(Long id) {
        List<Order> orders = getAllOrders();
        System.out.println(orders.size());
        for (Order order : orders) {
            if (Objects.equals(order.getId(), id)) {
                LocalDate currentDate = LocalDate.now();
                if (order.getShippingDate().isAfter(currentDate)) {
                    long hoursUntilShipping = ChronoUnit.HOURS.between(LocalDateTime.now(), order.getShippingDate().atStartOfDay());
                    System.out.println("hours until shipping: " + hoursUntilShipping);
                    if (hoursUntilShipping >= 24) {
                        orderRepository.cancelShipping(id);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

}
