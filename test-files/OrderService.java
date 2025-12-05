package test.files;

/**
 * OrderService - This will be called from master branch
 * This file exists in master and will be impacted by PR changes
 */
public class OrderService {
    
    private UserService userService;
    
    public OrderService() {
        this.userService = new UserService();
    }
    
    /**
     * Process order - calls UserService methods
     * This method will be impacted by UserService changes
     */
    public void processOrder(String userId, String orderId) {
        // Call UserService.getUserById - this will be impacted
        String user = userService.getUserById(userId);
        
        // Call UserService.validateUser - this will be impacted
        boolean isValid = userService.validateUser(userId);
        
        if (isValid) {
            System.out.println("Processing order: " + orderId + " for user: " + user);
        }
    }
    
    /**
     * Get order details - calls UserService
     */
    public String getOrderDetails(String userId) {
        // Call UserService.getUserById
        String user = userService.getUserById(userId);
        return "Order details for: " + user;
    }
    
    /**
     * Cancel order - calls UserService
     */
    public void cancelOrder(String userId, String orderId) {
        // Call UserService.validateUser
        boolean canCancel = userService.validateUser(userId);
        
        if (canCancel) {
            System.out.println("Cancelling order: " + orderId);
        }
    }
}

