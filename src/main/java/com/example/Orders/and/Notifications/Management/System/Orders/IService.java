package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        List<Order> orders =  orderRepository.getOrders();
        for (Object i : orders){
          System.out.println(i+" ;;");
       }
       // System.out.println(orderRepository.getOrders().size());
        for (Order order : orders) {
            System.out.println(order.getId());
            if (Objects.equals(order.getId(), id)) {
               // System.out.println("ana ena");
                LocalDate currentDate = LocalDate.now();
                long daysUntilShipping = ChronoUnit.DAYS.between(currentDate, order.getShippingDate());
               // long daysUntilShipping = 3;
                System.out.println("days"+daysUntilShipping);
                if (daysUntilShipping > 1) {
                    orderRepository.cancelShipping(id);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


}
