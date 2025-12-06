package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests that WILL FAIL due to breaking changes in TestSprint1Negative.java
 * Tests the test impact analysis feature
 */

public class TestSprint1NegativeTest {
    
    @Test
    public void testProcessOrder() {
        TestSprint1Negative service = new TestSprint1Negative();
        
        // TEST WILL FAIL: Method signature changed - missing quantity parameter
        service.processOrder("ORD-123");
        // Expected: processOrder(String orderId)
        // Actual: processOrder(String orderId, int quantity)
    }
    
    @Test
    public void testGetUserData() {
        TestSprint1Negative service = new TestSprint1Negative();
        
        // TEST WILL FAIL: Method is now private, cannot access
        String data = service.getUserData("USER-456");
        assertNotNull(data);
    }
    
    @Test
    public void testGetStatus() {
        TestSprint1Negative service = new TestSprint1Negative();
        
        // TEST WILL FAIL: Return type changed from int to String
        int status = service.getStatus(); // Compilation error!
        assertEquals(1, status);
    }
    
    @Test
    public void testCalculateDiscount() {
        TestSprint1Negative service = new TestSprint1Negative();
        
        // TEST WILL FAIL: Method signature changed - missing discountPercent parameter
        int discount = service.calculateDiscount(100);
        // Expected: calculateDiscount(int price)
        // Actual: calculateDiscount(int price, int discountPercent)
        assertEquals(10, discount);
    }
}

