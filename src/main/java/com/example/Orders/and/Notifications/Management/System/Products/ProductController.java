package com.example.Orders.and.Notifications.Management.System.Products;

import com.example.Orders.and.Notifications.Management.System.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/api")
public class ProductController {
    ProductService productService;
    @Autowired
    public ProductController( ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/add/product")
    public ResponseEntity<Product> addProduct (@RequestBody Product product){
       Product savedProduct =  productService.AddNewProduct(product);
        if(product != null) {
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAllProducts();
        if (!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
