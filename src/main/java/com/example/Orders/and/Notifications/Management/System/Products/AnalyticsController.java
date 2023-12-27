package com.example.Orders.and.Notifications.Management.System.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
    private final AnalyticsService analyticsService;
    @Autowired
    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }
    @GetMapping("/product-count/name")
    public ResponseEntity<Integer> getCategoryNumberOfProducts(@RequestBody String categoryName) {
        int numberOfProducts = analyticsService.getCategoryNumberOfProducts(categoryName);
        return new ResponseEntity<>(numberOfProducts, HttpStatus.OK);
    }
    @GetMapping("/Products-count")
    public ResponseEntity<Map<Category, Integer>> getProductsCountInCategory() {
        Map<Category, Integer> productsCount = analyticsService.getProductsCountInCategory();
        return new ResponseEntity<>(productsCount, HttpStatus.OK);
    }

}
