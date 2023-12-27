package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Users.User;

import java.util.List;

public class Order {
    private List<User> customers;
    private Long id;
    private List<com.example.Orders.and.Notifications.Management.System.Products.Product> products;
    private Long Price;
    private String ShippingAddress;
    private Type type;

    public Order(){}
    public Order(List<User> customers, Long id, List<com.example.Orders.and.Notifications.Management.System.Products.Product> products, Long price, String shippingAddress, Type type) {
        this.customers = customers;
        this.id = id;
        this.products = products;
        Price = price;
        ShippingAddress = shippingAddress;
        this.type = type;
    }
    public List<User> getCustomers() {
        return customers;
    }
    public void setCustomers(List<User> customers) {
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<com.example.Orders.and.Notifications.Management.System.Products.Product> getProducts() {
        return products;
    }

    public void setProducts(List<com.example.Orders.and.Notifications.Management.System.Products.Product> products) {
        this.products = products;
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
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
