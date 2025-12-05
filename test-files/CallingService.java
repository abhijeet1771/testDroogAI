package com.example;

/**
 * This file contains call sites that WILL BREAK due to changes in TestSprint1Negative.java
 * Tests the impact analysis and call site detection
 */

public class CallingService {
    
    public void processOrderFlow() {
        TestSprint1Negative service = new TestSprint1Negative();
        
        // CALL SITE 1: Will break - signature changed (missing quantity parameter)
        service.processOrder("ORD-123");
        
        // CALL SITE 2: Will break - method is now private
        String userData = service.getUserData("USER-456");
        
        // CALL SITE 3: Will break - return type changed from int to String
        int status = service.getStatus(); // Compilation error!
        
        // CALL SITE 4: Will break - signature changed (missing discountPercent)
        int discount = service.calculateDiscount(100);
    }
    
    public void orderProcessing() {
        TestSprint1Negative service = new TestSprint1Negative();
        
        // Another call site that will break
        service.processOrder("ORD-789");
    }
}
