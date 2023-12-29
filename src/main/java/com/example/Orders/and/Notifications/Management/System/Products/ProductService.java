package com.example.Orders.and.Notifications.Management.System.Products;

import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Vector;

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

    public Product getProductByID(String ID){
        return productRepository.getProductByID(ID);

    }


    public boolean updateQuantity(String ID, int quantity) {
        int currentQuantity = productRepository.getQuantity(ID);
       if (currentQuantity >= quantity) {
               return productRepository.updateQuantity(ID, currentQuantity - quantity);
       }
        return false;
    }


    public boolean increaseQuantity(String ID, int quantity) {
        int currentQuantity = productRepository.getQuantity(ID);
        if (currentQuantity >= quantity) {
            return productRepository.increaseQuantity(ID, currentQuantity + quantity);
        }
        return false;
    }

    public boolean checkAllProductsAvailability(Vector<Pair<Product,Integer>> products){
        for(Pair<Product,Integer> prod : products){
            int currentQuantity = productRepository.getQuantity(prod.getKey().getSerialNumber());
            if(currentQuantity - prod.getValue() <0){
                return false;
            }
        }
        return true;
    }

    public Map<Product, Integer> getAllProducts(){
        return productRepository.getProducts();
    }
}
