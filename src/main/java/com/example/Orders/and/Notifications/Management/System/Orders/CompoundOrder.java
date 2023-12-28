package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CompoundOrder extends Order{
    List<SimpleOrder> compoundOrder;

    public CompoundOrder() {
    }

    public CompoundOrder(Customer customer, Long id, Vector<Pair<Product, Integer>> orderProducts, int price, String shippingAddress, LocalDate shippingDate) {
        super(customer, id, orderProducts, price, shippingAddress, shippingDate);
    }
}