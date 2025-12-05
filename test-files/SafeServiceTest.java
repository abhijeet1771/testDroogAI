package com.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class that should NOT fail - tests safe changes
 */
public class SafeServiceTest {
    
    private SafeService service = new SafeService();
    
    // SAFE: Test for new method - should pass
    @Test
    public void testNewMethod() {
        service.newMethod("test-data");
        // Should pass - new method is safe
    }
    
    // SAFE: Test for unchanged method - should pass
    @Test
    public void testExistingMethod() {
        service.existingMethod("param");
        // Should pass - method signature unchanged
    }
    
    // SAFE: Test should not fail
    @Test
    public void testBuildMessage() {
        List<String> items = Arrays.asList("item1", "item2");
        String result = service.buildMessage(items);
        assertNotNull(result);
        // Should pass - no breaking changes
    }
}

