package com.example.Orders.and.Notifications.Management.System.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {
    ProductRepository productRepository;
    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product AddNewProduct(Product product){
        return productRepository.saveproduct(product);
    }

    public Product getProductByName(String Name){
        return productRepository.getProductByName(Name);
    }


    public boolean updateQuantity(Product product, int quantity) {
        int currentQuantity = productRepository.getQuantity(product);
        if (currentQuantity >= quantity) {
               return productRepository.updateQuantity(product, currentQuantity - quantity);
           }
        return false;
    }

    public Map<Product, Integer> getAllProducts(){
        return productRepository.getProducts();
    }
}
