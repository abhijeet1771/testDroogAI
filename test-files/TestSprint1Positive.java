package com.example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * POSITIVE SCENARIOS for Sprint 1 Testing
 * This file contains clean, well-written code
 * DroogAI should find ZERO issues here
 * Tests that the system doesn't generate false positives
 */

public class TestSprint1Positive {
    
    /**
     * Clean method with proper signature
     * No breaking changes, no performance issues
     */
    public void processOrder(String orderId) {
        System.out.println("Processing order: " + orderId);
    }
    
    /**
     * Well-designed method with proper visibility
     * Follows best practices
     */
    public String getUserData(String userId) {
        return "User data for: " + userId;
    }
    
    /**
     * Efficient implementation using Streams API
     * No performance regressions
     */
    public double calculateTotal(List<Item> items) {
        return items.stream()
            .mapToDouble(item -> item.getPrice() * item.getQuantity())
            .sum();
    }
    
    /**
     * Optimized batch processing
     * No N+1 query problem
     */
    public void processOrders(List<Order> orders) {
        // Fetch all users in one query
        List<String> userIds = orders.stream()
            .map(Order::getUserId)
            .distinct()
            .collect(Collectors.toList());
        
        // Batch fetch users
        List<User> users = userService.getUsersByIds(userIds);
        
        // Process orders with pre-fetched users
        orders.forEach(order -> {
            User user = users.stream()
                .filter(u -> u.getId().equals(order.getUserId()))
                .findFirst()
                .orElse(null);
            processOrder(order.getId());
        });
    }
    
    /**
     * Clean method with proper return type
     * No breaking changes
     */
    public int getStatus() {
        return 1; // 1 = active
    }
    
    /**
     * Well-designed discount calculation
     * No signature issues
     */
    public int calculateDiscount(int price, int discountPercent) {
        return price - (price * discountPercent / 100);
    }
}

