package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;

import java.time.LocalDate;
import java.util.Vector;

public class SimpleOrder extends Order{
    protected Customer customer = null;
    protected Vector<Pair<Product,Integer>> orderProducts= new Vector<>();
    protected int Price;
    protected String ShippingAddress = null;
    protected LocalDate ShippingDate = null;
    public LocalDate getShippingDate() {
        return ShippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        ShippingDate = shippingDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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


    public Vector<Pair<Product, Integer>> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Vector<Pair<Product, Integer>> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", id=" + id +
                ", orderProducts=" + orderProducts +
                ", price=" + Price +
                ", shippingAddress='" + ShippingAddress + '\'' +
                ", shippingDate=" + ShippingDate +
                ", orderType='" + type + '\'' +
                '}';
    }

    public SimpleOrder(String type, Long id, Customer customer, Vector<Pair<Product, Integer>> orderProducts, int price, String shippingAddress, LocalDate shippingDate) {
        super(type, id);
        this.customer = customer;
        this.orderProducts = orderProducts;
        Price = price;
        ShippingAddress = shippingAddress;
        ShippingDate = shippingDate;
    }

    public SimpleOrder(String type, Long id) {
        super(type, id);
    }
}