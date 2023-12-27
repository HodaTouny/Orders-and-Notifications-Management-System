package com.example.Orders.and.Notifications.Management.System.Products;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements ProductRepositoryInterface {
    Map<Product, Integer> products;
    ProductRepository(){
        products = new HashMap();
    }
    @Override
    public Product saveproduct(Product product) {
        if (products.containsKey(product)) {
            int quantity = products.get(product);
            products.put(product, quantity + 1);
        } else {

            products.put(product, 1);
        }
        return product;

    }
    @Override
    public boolean updateQuantity(Product product, int quantity) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().equals(product)) {
                products.put(product, quantity);
                return true;
            }
        }

        return false;
    }

    public int getQuantity(Product product) {
        return products.getOrDefault(product, 0);
    }


    @Override
    public Product getProductByName(String name) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
    @Override
    public Map<Product,Integer> getProducts() {
        return products;
    }


}
