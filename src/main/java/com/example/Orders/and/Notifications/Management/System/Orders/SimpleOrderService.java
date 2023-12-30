package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Vector;

@Service
public class SimpleOrderService extends IService {
    ProductService productService;
    CustomerService customerService;

    public SimpleOrderService(OrderRepositoryImp orderRepository, ProductService productService, CustomerService customerService) {
        super(orderRepository);
        this.productService = productService;
        this.customerService = customerService;
    }
    public boolean plaseSimpleOrder(Order order){
        Long toBeDecreased = (long) (((SimpleOrder)order).getPrice() + (0.05*((SimpleOrder)order).getPrice()));
        Vector<Pair<Product,Integer>> allProducts = ((SimpleOrder)order).getOrderProducts();
        if(productService.checkAllProductsAvailability(allProducts)) {
            if (customerService.decreaseBalance(((SimpleOrder)order).getCustomer().getId(), toBeDecreased)) {
                for (Pair<Product, Integer> prod : allProducts) {
                    productService.updateQuantity(prod.getKey().getSerialNumber(),prod.getValue());
                }
                return true;
            }
        }else{
            return false;
        }
        customerService.increaseBalance(((SimpleOrder)order).getCustomer().getId(),toBeDecreased);
        return false;
    }
    @Override
    public boolean placeOrder(Order order) {
        if(plaseSimpleOrder(order)){
            orderRepository.saveOrder(order);
            return true;
        }
        return false;
    }


}