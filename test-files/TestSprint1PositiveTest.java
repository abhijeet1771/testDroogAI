package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for positive scenarios
 * These tests should all pass
 * Tests that DroogAI doesn't flag clean test code
 */

public class TestSprint1PositiveTest {
    
    @Test
    public void testProcessOrder() {
        TestSprint1Positive service = new TestSprint1Positive();
        
        // Clean test - should pass
        service.processOrder("ORD-123");
        // No issues expected
    }
    
    @Test
    public void testGetUserData() {
        TestSprint1Positive service = new TestSprint1Positive();
        
        // Clean test - should pass
        String data = service.getUserData("USER-456");
        assertNotNull(data);
    }
    
    @Test
    public void testGetStatus() {
        TestSprint1Positive service = new TestSprint1Positive();
        
        // Clean test - should pass
        int status = service.getStatus();
        assertEquals(1, status);
    }
    
    @Test
    public void testCalculateDiscount() {
        TestSprint1Positive service = new TestSprint1Positive();
        
        // Clean test - should pass
        int discount = service.calculateDiscount(100, 10);
        assertEquals(90, discount);
    }
}

