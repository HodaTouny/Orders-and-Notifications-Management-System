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
    @Autowired
    public OrderService(OrderRepositoryImp orderRepository, ProductService productService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.customerService = customerService;
    }

    OrderRepositoryImp orderRepository;
    ProductService productService;
    CustomerService customerService;

    public boolean addOrder(SimpleOrder order){
        Long toBeDecreased = (long) (order.getPrice() + (0.5*order.getPrice()));
        Vector<Pair<Product,Integer>> allProducts = order.getOrderProducts();
        if(productService.checkAllProductsAvailability(allProducts)) {
            if (customerService.decreaseBalance(order.getCustomer().getId(), toBeDecreased)) {
                for (Pair<Product, Integer> prod : allProducts) {
                    productService.updateQuantity(prod.getKey().getSerialNumber(),prod.getValue());
                }
                return true;
            }
        }else{
            return false;
        }
        customerService.increaseBalance(order.getCustomer().getId(),toBeDecreased);
        return false;
    }
    public boolean addOrder(CompoundOrder order){
        List<SimpleOrder> ll = order.getCompoundOrder();
        for(SimpleOrder i : ll){
            addOrder(i);
        }
        return true;
    }

    public List<Order> getAllOrders(){
        return orderRepository.getOrders();
    }
    public void getOrderByID(Long id){
        orderRepository.getOrderByID(id);
    }
    public boolean cancelOrder(Order order){
        return false;

    }
    public boolean cancelShipping(Order order){
       return true;
    }
}