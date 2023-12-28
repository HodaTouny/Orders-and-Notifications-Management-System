package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Users.Customer;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

public class CompoundOrder extends Order{
    List<SimpleOrder> compoundOrder;

    public CompoundOrder(Customer customer, Long id, List<CartItem> cartItems, Long price, String shippingAddress) {
        super(customer, id, cartItems, price, shippingAddress);
        this.compoundOrder=new ArrayList<>();
    }
}