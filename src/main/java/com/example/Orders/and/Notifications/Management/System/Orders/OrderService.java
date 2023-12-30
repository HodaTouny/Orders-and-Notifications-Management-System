package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;

@Service
public class OrderService {
    OrderRepositoryImp orderRepository;
    ProductService productService;
    CustomerService customerService;
    @Autowired
    public OrderService(OrderRepositoryImp orderRepository, ProductService productService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.customerService = customerService;
    }

    public boolean addOrder(Order order) {
        return false;
    }

    public List<Order> getAllOrders(){
        return orderRepository.getOrders();
    }
    public void getOrderByID(Long id){
        orderRepository.getOrderByID(id);
    }

    public boolean cancelOrder(Order order) {
        return false;
    }

    public boolean cancelShipping(Order order) {
        return false;
    }
}