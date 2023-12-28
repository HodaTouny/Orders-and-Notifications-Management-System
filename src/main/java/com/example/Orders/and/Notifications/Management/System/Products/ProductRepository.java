package com.example.Orders.and.Notifications.Management.System.Products;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements ProductRepositoryInterface {
    Map<Product, Integer> products;
    ProductRepository(){
        products = new HashMap();
    }
    @Override
    public Product saveproduct(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {

            Product productt = entry.getKey();
            int productCount = entry.getValue();
            if(Objects.equals(product.getSerialNumber(), productt.getSerialNumber())) {
                products.put(productt, productCount + 1);
                return product;
            }
        }
            products.put(product, 1);
            return product;
    }

    @Override
    public boolean updateQuantity(int ID, int quantity) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getSerialNumber()==ID){
                Product product = getProductByID(ID);
                products.put(product, quantity);
                return true;
            }
        }

        return false;
    }

    public int getQuantity(int ID) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            int productId = entry.getKey().getSerialNumber();
            if (ID==productId) {
                return entry.getValue();
            }
        }
        return -1;
    }


    @Override
    public Product getProductByID(int ID) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            if (product.getSerialNumber()==ID) {
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
