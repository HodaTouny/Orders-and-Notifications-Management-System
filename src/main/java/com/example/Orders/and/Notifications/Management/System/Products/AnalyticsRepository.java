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
            Map<Product, Integer> products = productRepository.getProducts();

            for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                Product product = entry.getKey();
                int productCount = entry.getValue();
                Category category = product.getCategory();

                categoryCount.put(category, categoryCount.getOrDefault(category, 0) + productCount);
            }

            return categoryCount;
        }

    }

