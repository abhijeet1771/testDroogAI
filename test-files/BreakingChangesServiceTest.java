package com.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class that WILL FAIL due to breaking changes
 */
public class BreakingChangesServiceTest {
    
    private BreakingChangesService service = new BreakingChangesService();
    
    // WILL FAIL: Test calls processData with old signature (missing format parameter)
    @Test
    public void testProcessData() {
        service.processData("test-data"); // BREAKING: Missing second parameter
        // Test will fail to compile
    }
    
    // WILL FAIL: Test calls getUserInfo which is now private
    @Test
    public void testGetUserInfo() {
        String result = service.getUserInfo("user123"); // BREAKING: Method is private
        assertEquals("User: user123", result);
    }
    
    // WILL FAIL: Test expects String but method returns int
    @Test
    public void testGetStatus() {
        String status = service.getStatus(); // BREAKING: Return type changed to int
        assertEquals("OK", status);
    }
    
    // WILL FAIL: Test calls updateUser with Long but expects String
    @Test
    public void testUpdateUser() {
        service.updateUser(12345L); // BREAKING: Parameter type changed to String
    }
}

