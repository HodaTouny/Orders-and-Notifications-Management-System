package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public abstract class IService {
    OrderRepositoryImp orderRepository;
    ProductService productService;
    CustomerService customerService;
    @Autowired
    public IService(OrderRepositoryImp orderRepository, ProductService productService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.customerService = customerService;
    }
    public List<Order> getAllOrders(){
        return orderRepository.getOrders();
    }
    public void getOrderByID(Long id){
        orderRepository.getOrderByID(id);
    }
    public abstract boolean placeOrder(Order order);

}