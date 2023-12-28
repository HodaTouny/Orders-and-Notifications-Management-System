package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CompoundOrder implements Order {

    private Customer customer;
    private Long id;
    private Vector<Pair<Product, Integer>> orderProducts;
    private int price;
    private String shippingAddress;
    private List<SimpleOrder> compoundOrder;

    public CompoundOrder() {
    }

    public CompoundOrder(Customer customer, Long id, Vector<Pair<Product, Integer>> orderProducts, int price, String shippingAddress) {
        this.customer = customer;
        this.id = id;
        this.orderProducts = orderProducts;
        this.price = price;
        this.shippingAddress = shippingAddress;
        this.compoundOrder = new ArrayList<>();
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Vector<Pair<Product, Integer>> getOrderProducts() {
        return orderProducts;
    }

    @Override
    public void setOrderProducts(Vector<Pair<Product, Integer>> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<SimpleOrder> getCompoundOrder() {
        return compoundOrder;
    }

    public void setCompoundOrder(List<SimpleOrder> compoundOrder) {
        this.compoundOrder = compoundOrder;
    }

}
