package test.files;

/**
 * PaymentProcessor - This exists in main branch
 * This file calls UserService methods and will be impacted by PR changes
 */
public class PaymentProcessor {
    
    private UserService userService;
    
    public PaymentProcessor() {
        this.userService = new UserService();
    }
    
    /**
     * Process payment - calls UserService methods
     * This will be impacted by UserService signature changes
     */
    public boolean processPayment(String userId, double amount) {
        // Call UserService.getUserById - BREAKING CHANGE SCENARIO
        String user = userService.getUserById(userId);
        
        // Call UserService.validateUser - BREAKING CHANGE SCENARIO
        boolean isValid = userService.validateUser(userId);
        
        if (isValid && user != null) {
            System.out.println("Processing payment: " + amount + " for user: " + user);
            return true;
        }
        return false;
    }
    
    /**
     * Refund payment - calls UserService
     */
    public void refundPayment(String userId, String transactionId) {
        // Call UserService.getUserById
        String user = userService.getUserById(userId);
        System.out.println("Refunding transaction: " + transactionId + " for user: " + user);
    }
    
    /**
     * Validate payment - calls UserService
     */
    public boolean validatePayment(String userId) {
        // Call UserService.validateUser
        return userService.validateUser(userId);
    }
}
