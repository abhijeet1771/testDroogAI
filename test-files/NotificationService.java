package test.files;

/**
 * NotificationService - This will be called from master branch
 * This file exists in master and will be impacted by PR changes
 */
public class NotificationService {
    
    private UserService userService;
    
    public NotificationService() {
        this.userService = new UserService();
    }
    
    /**
     * Send notification - calls UserService
     * This will be impacted by UserService changes
     */
    public void sendNotification(String userId, String message) {
        // Call UserService.getUserById - BREAKING CHANGE SCENARIO
        String user = userService.getUserById(userId);
        
        if (user != null) {
            System.out.println("Sending notification to: " + user + " - " + message);
        }
    }
    
    /**
     * Send email - calls UserService
     */
    public void sendEmail(String userId, String subject) {
        // Call UserService.getUserById
        String user = userService.getUserById(userId);
        System.out.println("Sending email to: " + user + " - Subject: " + subject);
    }
}

