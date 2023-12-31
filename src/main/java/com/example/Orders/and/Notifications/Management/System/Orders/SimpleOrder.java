package com.example.Orders.and.Notifications.Management.System.Orders;
import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Notifications.*;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.security.ProtectionDomain;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;
public class SimpleOrder extends Order{

    protected Customer customer = null;

    protected int price;
    protected String shippingAddress = null;
    protected Vector<Pair<Product,Integer>> orderProducts= new Vector<>();
    protected ChannelFactory channelFactory = new ChannelFactoryImpl();
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public Vector<Pair<Product, Integer>> getOrderProducts() {
        return orderProducts;
    }
    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }
    public List<Channel> getChannels() {
        return channels;
    }

    public SimpleOrder(Customer customer, int price, String shippingAddress, LocalDate shippingDate, Vector<Pair<Product, Integer>> orderProducts, List<String>channelsTypes) {
        this.customer = customer;
        this.price = price;
        this.shippingAddress = shippingAddress;
        this.shippingDate = shippingDate;
        this.orderProducts = orderProducts;
        this.channels = new Vector<>();
        for (String channelType : channelsTypes) {
            Channel channel = channelFactory.createChannel(channelType);
            channels.add(channel);
        }
    }

    @Override
    public String toString() {
        return "SimpleOrder{" +
                "customer=" + customer +
                ", Price=" + price +
                ", ShippingAddress='" + shippingAddress + '\'' +
                ", ShippingDate=" + shippingDate +
                ", orderProducts=" + orderProducts +
                ", id=" + id +
                '}';
    }

    public void setOrderProducts(Vector<Pair<Product, Integer>> orderProducts) {
        this.orderProducts = orderProducts;
    }
}