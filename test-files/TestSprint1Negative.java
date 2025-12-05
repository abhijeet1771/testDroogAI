package com.example;

/**
 * NEGATIVE SCENARIOS for Sprint 1 Testing
 * This file contains intentional issues to test:
 * 1. Consolidated PR summary (breaking changes, test failures, performance regressions)
 * 2. Human-like comment formatting
 * 3. Conversational tone
 */

public class TestSprint1Negative {
    
    // BREAKING CHANGE: Method signature changed (will break call sites)
    public void processOrder(String orderId, int quantity) {
        // Old signature: processOrder(String orderId)
        // This will break all existing call sites
        System.out.println("Processing order: " + orderId + ", quantity: " + quantity);
    }
    
    // BREAKING CHANGE: Visibility reduced from public to private
    private String getUserData(String userId) {
        // This was public before, now private - will break external callers
        return "User data for: " + userId;
    }
    
    // PERFORMANCE REGRESSION: N+1 query problem
    public void processOrders(List<Order> orders) {
        for (Order order : orders) {
            // This will execute one query per order - N+1 problem
            User user = userService.getUserById(order.getUserId());
            processOrder(order.getId(), order.getQuantity());
        }
    }
    
    // PERFORMANCE REGRESSION: Inefficient loop
    public void calculateTotal(List<Item> items) {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size(); j++) {
                // O(n^2) complexity - will slow down with large lists
                total += items.get(i).getPrice() * items.get(j).getQuantity();
            }
        }
    }
    
    // TEST FAILURE: Method that tests will call but signature changed
    public int calculateDiscount(int price, int discountPercent) {
        // Old signature: calculateDiscount(int price)
        // Tests will fail because they expect old signature
        return price - (price * discountPercent / 100);
    }
    
    // BREAKING CHANGE: Return type changed
    public String getStatus() {
        // Old return type: int
        // This will break all code expecting int return value
        return "active";
    }
}

