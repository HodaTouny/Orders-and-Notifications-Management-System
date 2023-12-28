package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;

import java.util.Vector;

public interface Order {

    Customer getCustomer();

    void setCustomer(Customer customer);

    Long getId();

    void setId(Long id);

    int getPrice();

    void setPrice(int price);

    String getShippingAddress();

    void setShippingAddress(String shippingAddress);

    Vector<Pair<Product, Integer>> getOrderProducts();

    void setOrderProducts(Vector<Pair<Product, Integer>> orderProducts);

}

