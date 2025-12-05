package com.example.service;

/**
 * Service with safe changes - no breaking changes, no performance regressions
 * This should NOT trigger any "will break" warnings
 */
public class SafeService {
    
    // SAFE: New method added (not breaking)
    public void newMethod(String data) {
        // New functionality - safe addition
    }
    
    // SAFE: Method with same signature (unchanged)
    public void existingMethod(String param) {
        // Unchanged method - safe
    }
    
    // SAFE: Private method changed (not breaking for external callers)
    private void internalMethod(String data) {
        // Internal change - safe
    }
    
    // SAFE: Performance improvement - using StringBuilder
    public String buildMessage(List<String> items) {
        StringBuilder message = new StringBuilder();
        for (String item : items) {
            message.append(item).append(", "); // GOOD: StringBuilder instead of concatenation
        }
        return message.toString();
    }
    
    // SAFE: Batch query instead of N+1
    public List<String> getOrdersWithUsers(List<Long> orderIds) {
        // GOOD: Single batch query
        return getUsersByIds(orderIds); // Batch query
    }
    
    private List<String> getUsersByIds(List<Long> ids) {
        // Simulated batch query
        return new ArrayList<>();
    }
}
