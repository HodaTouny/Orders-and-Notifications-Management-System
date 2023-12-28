package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;

import java.time.LocalDate;
import java.util.Vector;

public class SimpleOrder extends Order{
    public SimpleOrder() {
    }

    public SimpleOrder(Customer customer, Long id, Vector<Pair<Product, Integer>> orderProducts, int price, String shippingAddress, LocalDate shippingDate) {
        super(customer, id, orderProducts, price, shippingAddress, shippingDate);
    }
}