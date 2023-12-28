package com.example.Orders.and.Notifications.Management.System.Products;

public class Product {
    int serialNumber;
    String vendor;
    String name;
    int price;
    Category category;


    public Product (){}

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public Product(int serialNumber, String vendor, String name, int price, Category category) {
        this.serialNumber = serialNumber;
        this.vendor = vendor;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
