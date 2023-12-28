package com.example.Orders.and.Notifications.Management.System.Products;

import java.util.Map;

public interface ProductRepositoryInterface {
    Product saveproduct(Product product);
    Product getProductByName(String name);
    Map<Product,Integer> getProducts();

    boolean updateQuantity(Product product, int quantity);
}
