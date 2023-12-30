package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class FactoryOrderImpl implements FactoryOrder {
    private final ProductService productService;
    private final CustomerService customerService;
    private final OrderRepository orderRepository;
    public FactoryOrderImpl(ProductService productService, CustomerService customerService,OrderRepository orderRepository) {
        this.productService = productService;
        this.customerService = customerService;
        this.orderRepository = orderRepository;
    }
    @Override
    public IService create(Order order) {
        if (order instanceof SimpleOrder) {
            return new SimpleOrderService(orderRepository, productService, customerService);
        } else if (order instanceof CompoundOrder) {
            return new CompoundOrderService(orderRepository,
                    new SimpleOrderService(orderRepository, productService, customerService),
                    customerService,productService);
        }
        return null;
    }
}