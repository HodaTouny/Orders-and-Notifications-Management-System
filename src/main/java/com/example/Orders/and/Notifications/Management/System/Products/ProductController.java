package com.example.Orders.and.Notifications.Management.System.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @GetMapping("products")
    public ResponseEntity<Map<Product,Integer>> getProducts() {
        Map<Product,Integer> products = productService.getAllProducts();
        if (!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping("/update-quantity")
    public ResponseEntity<List<Product>> updateQuantity(@RequestBody Map<Product, Integer> orderedProducts) {
        List<Product> failedUpdates = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : orderedProducts.entrySet()) {
            Product product = entry.getKey();
            Integer newQuantity = entry.getValue();

            boolean updateResult = productService.updateQuantity(product, newQuantity);

            if (!updateResult) {
                failedUpdates.add(product);
            }
        }

        if (failedUpdates.isEmpty()) {
            return new ResponseEntity<>(failedUpdates, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(failedUpdates,HttpStatus.NOT_ACCEPTABLE);

        }
    }
}