package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;

import java.util.*;

public abstract class Order {


    protected Customer customer = null;
    protected Long id = null;
    protected Vector<Pair<Product,Integer>> orderProducts= new Vector<>();
    protected int Price;
    protected String ShippingAddress = null;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    public Order() {
        this.customer = null;
        this.id = null;
        this.orderProducts = new Vector<>();
        ShippingAddress = null;
    };

    public Vector<Pair<Product, Integer>> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Vector<Pair<Product, Integer>> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Order(Customer customer, Long id, Vector<Pair<Product, Integer>> orderProducts, int price, String shippingAddress) {
        this.customer = customer;
        this.id = id;
        this.orderProducts = orderProducts;
        Price = price;
        ShippingAddress = shippingAddress;
    }
}

