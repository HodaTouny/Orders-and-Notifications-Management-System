package com.example.Orders.and.Notifications.Management.System.Products;

import java.util.Map;

public interface ProductRepositoryInterface {
    Product saveproduct(Product product);
    Product getProductByID(int ID);
    Map<Product,Integer> getProducts();

    boolean updateQuantity(int ID, int quantity);
}
