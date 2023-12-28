package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;

public class CompoundOrderManager extends OrderManager{
    public CompoundOrderManager(OrderService orderService, CustomerService customerService, ProductService productService) {
        super(orderService, customerService, productService);
    }

    public CompoundOrderManager() {
    }

    @Override
    public boolean changeableCodeForConfirm() {
        return false;
    }

    @Override
    public boolean changeableCodeForCancelOrder() {
        return false;
    }

    @Override
    public boolean changeableCodeForCancelOrderShipping() {
        return false;
    }


}
