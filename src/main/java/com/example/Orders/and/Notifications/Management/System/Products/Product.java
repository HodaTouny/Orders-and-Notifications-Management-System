package com.example.Orders.and.Notifications.Management.System.Products;

import com.example.Orders.and.Notifications.Management.System.Users.User;

public class Product {
    Long serialNumber;
    String vendor;
    String name;
    Long price;
    Category category;

    public Product (){}

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
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

    public Product(Long serialNumber, String vendor, String name, Long price, Category category) {
        this.serialNumber = serialNumber;
        this.vendor = vendor;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
