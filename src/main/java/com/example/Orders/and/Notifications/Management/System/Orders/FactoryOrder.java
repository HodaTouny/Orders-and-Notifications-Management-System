package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;

public interface FactoryOrder {
    IService create(String type, ProductService p , CustomerService c , OrderRepositoryImp o);
}
