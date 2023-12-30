package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class FactoryOrderImpl implements FactoryOrder {

    private final ProductService productService;
    private final CustomerService customerService;

    public FactoryOrderImpl(ProductService productService, CustomerService customerService) {
        this.productService = productService;
        this.customerService = customerService;
    }

    @Override
    public IService create(Order order) {
        if (order instanceof SimpleOrder) {
            return new SimpleOrderService(new OrderRepositoryImp(), productService, customerService);
        } else if (order instanceof CompoundOrder) {
            return new CompoundOrderService(new OrderRepositoryImp(), new SimpleOrderService(new OrderRepositoryImp(), productService, customerService));
        }
        return null;
    }
}