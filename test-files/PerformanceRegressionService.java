package com.example.service;

import java.util.List;
import java.util.ArrayList;

/**
 * Service with performance regressions - code will be slower
 */
public class PerformanceRegressionService {
    
    // PERFORMANCE REGRESSION: N+1 query problem
    // Complexity: HIGH - will cause significant slowdown
    public List<String> getOrdersWithUsers(List<Long> orderIds) {
        List<String> results = new ArrayList<>();
        for (Long orderId : orderIds) {
            // BAD: Query inside loop - N+1 problem
            String user = getUserById(orderId); // One query per order
            results.add(user);
        }
        return results;
    }
    
    // PERFORMANCE REGRESSION: String concatenation in loop
    // Complexity: MEDIUM - O(n²) string operations
    public String buildMessage(List<String> items) {
        String message = "";
        for (String item : items) {
            message += item + ", "; // BAD: String concatenation in loop
        }
        return message;
    }
    
    // PERFORMANCE REGRESSION: Excessive object creation
    // Complexity: MEDIUM - increased memory allocation
    public void processItems(List<String> items) {
        for (String item : items) {
            new Processor().process(item); // BAD: Creating new object in loop
            new Validator().validate(item);
            new Formatter().format(item);
            new Logger().log(item);
            new Reporter().report(item);
        }
    }
    
    // PERFORMANCE REGRESSION: High complexity increase
    // Complexity: HIGH - nested loops and conditions
    public void complexProcessing(List<String> data) {
        for (String item : data) {
            if (item != null) {
                for (String subItem : item.split(",")) {
                    if (subItem.length() > 0) {
                        for (char c : subItem.toCharArray()) {
                            if (Character.isDigit(c)) {
                                // Nested complexity
                                process(c);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private String getUserById(Long id) {
        // Simulated database query
        return "User" + id;
    }
    
    private void process(char c) {
        // Process character
    }
    
    // Helper classes for demonstration
    private class Processor { void process(String s) {} }
    private class Validator { void validate(String s) {} }
    private class Formatter { void format(String s) {} }
    private class Logger { void log(String s) {} }
    private class Reporter { void report(String s) {} }
}

