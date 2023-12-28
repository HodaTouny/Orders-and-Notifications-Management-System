package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CompoundOrder extends Order{
    List<SimpleOrder> compoundOrder;

    public CompoundOrder(Customer customer, Long id, Vector<Pair<Integer, Integer>> orderProducts, int price, String shippingAddress) {
        super(customer, id, orderProducts, price, shippingAddress);
        this.compoundOrder=new ArrayList<>();
    }
}