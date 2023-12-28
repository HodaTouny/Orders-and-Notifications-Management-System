package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Order {
    List<Customer> customers = null;
     Long id = null;
     Map<Product, Integer> productsQuantity = new HashMap<>();
     Long Price = null;
     String ShippingAddress = null;

}
