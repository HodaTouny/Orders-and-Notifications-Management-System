package com.example.Orders.and.Notifications.Management.System.Products;

import java.util.Map;

public interface ProductRepositoryInterface {
    Product saveproduct(Product product);
    Product getProductByID(String ID);
    Map<Product,Integer> getProducts();

    boolean updateQuantity(String ID, int quantity);

}
