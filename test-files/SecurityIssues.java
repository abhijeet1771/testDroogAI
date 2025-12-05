/**
 * Security Issues Test File
 * Contains various security vulnerabilities for DroogAI to detect
 */
public class SecurityIssues {
    
    // CRITICAL: Hardcoded API key
    private static final String API_KEY = "sk_live_1234567890abcdef";
    
    // CRITICAL: Hardcoded password
    private String password = "admin123";
    
    // HIGH: SQL Injection vulnerability
    public User getUserById(String userId) {
        String query = "SELECT * FROM users WHERE id = " + userId;
        // SQL injection risk - should use prepared statements
        return executeQuery(query);
    }
    
    // HIGH: XSS vulnerability
    public String displayUserInput(String userInput) {
        return "<div>" + userInput + "</div>"; // XSS risk - should escape HTML
    }
    
    // HIGH: IDOR vulnerability - no authorization check
    public void deleteUser(Long userId) {
        // Missing authorization check - any user can delete any other user
        database.deleteUser(userId);
    }
    
    // MEDIUM: Weak encryption
    public String encryptPassword(String password) {
        // Using weak MD5 - should use bcrypt or Argon2
        return MD5.hash(password);
    }
    
    // MEDIUM: Sensitive data in logs
    public void logUserData(User user) {
        logger.info("User data: " + user.getPassword() + ", " + user.getCreditCard());
        // Should not log sensitive data
    }
    
    // LOW: Missing HTTPS enforcement
    public void connectToAPI() {
        String url = "http://api.example.com/data"; // Should use HTTPS
        // ...
    }
}

