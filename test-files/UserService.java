package test.files;

/**
 * UserService - This is the file being changed in PR
 * 
 * NEGATIVE SCENARIO (Breaking Changes):
 * - getUserById() signature changed (BREAKING)
 * - validateUser() visibility changed to private (BREAKING)
 * 
 * POSITIVE SCENARIO (Safe Changes):
 * - New method added (safe)
 * - Helper method added (safe)
 */
public class UserService {
    
    private String defaultUser = "guest";
    
    /**
     * BREAKING CHANGE: Method signature changed
     * OLD: public String getUserById(String userId)
     * NEW: public User getUserById(String userId, boolean includeDetails)
     * 
     * This will break all call sites in master branch:
     * - OrderService.processOrder()
     * - PaymentProcessor.processPayment()
     * - NotificationService.sendNotification()
     */
    public User getUserById(String userId, boolean includeDetails) {
        // Changed return type from String to User
        // Added new parameter
        User user = new User();
        user.setId(userId);
        user.setName("User " + userId);
        if (includeDetails) {
            user.setEmail(userId + "@example.com");
        }
        return user;
    }
    
    /**
     * BREAKING CHANGE: Visibility reduced from public to private
     * OLD: public boolean validateUser(String userId)
     * NEW: private boolean validateUser(String userId)
     * 
     * This will break all external call sites:
     * - OrderService.processOrder()
     * - PaymentProcessor.processPayment()
     * - PaymentProcessor.validatePayment()
     */
    private boolean validateUser(String userId) {
        // Changed from public to private
        // External classes can no longer call this
        return userId != null && !userId.isEmpty();
    }
    
    /**
     * POSITIVE SCENARIO: New public method added (safe, non-breaking)
     * This is a new method, so it won't break existing code
     */
    public boolean isUserActive(String userId) {
        // New method - safe addition
        return userId != null && userId.startsWith("active_");
    }
    
    /**
     * POSITIVE SCENARIO: New helper method (safe, non-breaking)
     */
    public String getUserDisplayName(String userId) {
        // New method - safe addition
        User user = getUserById(userId, false);
        return user != null ? user.getName() : defaultUser;
    }
    
    /**
     * POSITIVE SCENARIO: Method with same signature (safe)
     * This method wasn't changed, so it's safe
     */
    public void updateUser(String userId, String name) {
        // Unchanged method - safe
        System.out.println("Updating user: " + userId + " with name: " + name);
    }
    
    /**
     * Inner class for User object
     */
    public static class User {
        private String id;
        private String name;
        private String email;
        
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
}
