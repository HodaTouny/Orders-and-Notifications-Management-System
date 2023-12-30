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



    public SimpleOrder(Customer customer, Long id, Vector<Pair<Product, Integer>> orderProducts, int price, String shippingAddress, LocalDate shippingDate) {
        this.customer = customer;
        this.id = id;
        this.orderProducts = orderProducts;
        Price = price;
        ShippingAddress = shippingAddress;
        ShippingDate = shippingDate;
        //this.orderType = orderType;
    }
//    public String getOrderType() {
//        return orderType;
//    }
//    public void setOrderType(String orderType) {
//        this.orderType = orderType;
//    }

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

    public SimpleOrder() {
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

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", id=" + id +
                ", orderProducts=" + orderProducts +
                ", price=" + Price +
                ", shippingAddress='" + ShippingAddress + '\'' +
                ", shippingDate=" + ShippingDate +
               // ", orderType='" + orderType + '\'' +
                '}';
    }
}