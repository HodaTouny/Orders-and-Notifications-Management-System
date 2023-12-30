package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;

import java.util.Objects;

public class FactoryOrderImpl implements FactoryOrder{
    @Override
    public IService create(String type, ProductService p , CustomerService c , OrderRepositoryImp o) {
        if(Objects.equals(type, "simple")){
            return new SimpleOrderService(o,p,c);
        }
        return null;
    }
}
