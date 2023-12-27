package com.example.Orders.and.Notifications.Management.System.Orders;

import org.apache.catalina.User;

import java.util.List;

public class CompoundOrder implements Order{
    List<User> customers;
    List<Order> compoundOrder;
}