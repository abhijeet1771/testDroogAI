package com.example.service;

/**
 * Another service that will break
 */
public class PaymentProcessingService {
    
    private BreakingChangesService breakingService = new BreakingChangesService();
    
    // WILL BREAK: Line 12 - Calls processData
    public void processPayment(String paymentData) {
        breakingService.processData(paymentData); // Missing format parameter
    }
    
    // WILL BREAK: Line 17 - Calls updateUser with wrong type
    public void updatePaymentUser(Long userId) {
        breakingService.updateUser(userId); // Expects String, gets Long
    }
}

