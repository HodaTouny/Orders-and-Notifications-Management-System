package com.example.Orders.and.Notifications.Management.System.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AnalyticsRepository {
    ProductRepository productRepository;
    @Autowired
    public AnalyticsRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Map<Category, Integer> groupByCategory() {
        Map<Category, Integer> categoryCount = new HashMap<>();
        List<Product> Products = productRepository.getProducts();
        for (Product product : Products) {
            Category category = product.getCategory();
            if (category != null) {
                categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
            }
        }

        return categoryCount;
    }

}
