package com.example.Orders.and.Notifications.Management.System.Products;

import com.example.Orders.and.Notifications.Management.System.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return productRepository.getProductbyName(Name);
    }

    public List<Product> getAllProducts(){
        return productRepository.getProducts();
    }
}
