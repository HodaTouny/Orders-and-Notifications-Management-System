package com.example.Orders.and.Notifications.Management.System.Products;

import com.example.Orders.and.Notifications.Management.System.Customize.ProductSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ProductSerialize.class)
public class Product {
    String serialNumber;
    String vendor;
    String name;
    double price;
    Category category;


    public Product (){}

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }


    @Override
    public String toString() {
        return "Product{" +
                "serialNumber=" + serialNumber +
                ", vendor=" + vendor +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';

    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(String serialNumber, String vendor, String name, double price, Category category) {
        this.serialNumber = serialNumber;
        this.vendor = vendor;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
