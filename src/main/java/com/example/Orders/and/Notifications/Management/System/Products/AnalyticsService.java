package com.example.Orders.and.Notifications.Management.System.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {
    AnalyticsRepository analyticsRepository;
    @Autowired
    public AnalyticsService(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }
    public int getCategoryNumberOfProducts(String categoryName) {
        Map<Category, Integer> categoryCount = analyticsRepository.groupByCategory();

        for (Map.Entry<Category, Integer> entry : categoryCount.entrySet()) {
            Category category = entry.getKey();
            if (category != null && category.name().equalsIgnoreCase(categoryName)) {
                return entry.getValue();
            }
        }
        return 0;
    }
    public Map<Category, Integer> getProductsCountInCategory() {
        return analyticsRepository.groupByCategory();
    }
}