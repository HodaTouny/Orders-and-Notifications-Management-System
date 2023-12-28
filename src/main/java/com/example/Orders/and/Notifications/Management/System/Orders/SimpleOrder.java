package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;
import org.apache.catalina.User;

import java.util.List;
import java.util.Vector;

public class SimpleOrder extends Order{

    public SimpleOrder(Customer customer, Long id, Vector<Pair<Product, Integer>> orderProducts, int price, String shippingAddress) {
        super(customer, id, orderProducts, price, shippingAddress);
    }
}
