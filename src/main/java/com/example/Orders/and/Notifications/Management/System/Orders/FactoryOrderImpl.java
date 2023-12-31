package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Notifications.NotificationController;
import com.example.Orders.and.Notifications.Management.System.Notifications.NotificationFactory;
import com.example.Orders.and.Notifications.Management.System.Notifications.NotificationFactoryImpl;
import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class FactoryOrderImpl implements FactoryOrder {
    private final ProductService productService;
    private final CustomerService customerService;
    private final OrderRepository orderRepository;
    private final NotificationFactoryImpl notificationFactory;
    private final NotificationController notificationController;
    public FactoryOrderImpl(ProductService productService, CustomerService customerService,OrderRepository orderRepository, NotificationFactoryImpl notificationFactory, NotificationController notificationController) {
        this.productService = productService;
        this.customerService = customerService;
        this.orderRepository = orderRepository;
        this.notificationFactory = notificationFactory;
        this.notificationController = notificationController;

    }
    @Override
    public IService create(Order order) {
        if (order instanceof SimpleOrder) {
            return new SimpleOrderService(orderRepository, productService, customerService,notificationFactory,notificationController);
        } else if (order instanceof CompoundOrder) {
            return new CompoundOrderService(orderRepository,
                    new SimpleOrderService(orderRepository, productService, customerService,notificationFactory,notificationController),
                    customerService,productService,notificationFactory,notificationController);
        }
        return null;
    }
}