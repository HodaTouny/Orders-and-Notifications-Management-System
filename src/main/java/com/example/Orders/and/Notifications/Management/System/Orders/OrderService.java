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
    OrderRepository orderRepository;
    ProductService productService;
    CustomerService customerService;
    @Autowired
    OrderService(OrderRepository orderRepository,ProductService productService ,CustomerService customerService){
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.customerService = customerService;
    }
    public Order addOrder(Order order){
        Long fees;
        Vector<Pair<Product,Integer>> OrderProducts = order.getOrderProducts();
        for(Pair<Product, Integer> product1 : OrderProducts){
           Product product = product1.getKey();
            int quantity = product1.getValue();
            productService.updateQuantity(product.getSerialNumber(),quantity);
        }
        int x = order.getPrice();
        fees = (long) (0.5 * x);
        customerService.updateBalance(order.getCustomer(),fees);
        return orderRepository.saveOrder(order);
    }
    public List<Order> getAllOrders(){
        return orderRepository.getOrders();
    }
    public void getOrderByID(Long id){
        orderRepository.getOrderByID(id);
    }


}
