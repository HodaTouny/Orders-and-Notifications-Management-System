package com.example.Orders.and.Notifications.Management.System.Products;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    List<Product>products;
    ProductRepository(){
        products = new ArrayList<>();
    }

    public Product saveproduct(Product product) {
        products.add(product);
        return product;
    }

    public Product getProductbyName(String name) {
        for (Product product : products) {
            if (name == product.getName()) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts(){
        return products;
    }

}
