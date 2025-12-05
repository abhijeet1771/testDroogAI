package com.example.service;

/**
 * Service that will be impacted by breaking changes
 * Multiple call sites - high impact
 */
public class OrderProcessingService {
    
    private BreakingChangesService breakingService = new BreakingChangesService();
    
    // WILL BREAK: Line 15 - Calls processData with old signature
    public void processOrder(String orderData) {
        breakingService.processData(orderData); // Missing format parameter
    }
    
    // WILL BREAK: Line 20 - Calls getUserInfo which is now private
    public void getOrderUser(String userId) {
        String userInfo = breakingService.getUserInfo(userId);
        // Process user info
    }
    
    // WILL BREAK: Line 26 - Return type mismatch
    public void validateOrder() {
        String status = breakingService.getStatus(); // Expects String, gets int
        if (status.equals("OK")) {
            // Process
        }
    }
}

