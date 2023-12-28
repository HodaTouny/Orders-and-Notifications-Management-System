package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Order {


    protected Customer customer = new Customer();
    protected Long id = null;
    protected List<CartItem> cartItems = new ArrayList<>();
    protected Long Price = null;
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

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    public Order() {};

    public Order(Customer customer, Long id, List<CartItem> cartItems, Long price, String shippingAddress) {
        this.customer = customer;
        this.id = id;
        this.cartItems = cartItems;
        Price = price;
        ShippingAddress = shippingAddress;
    }

}

