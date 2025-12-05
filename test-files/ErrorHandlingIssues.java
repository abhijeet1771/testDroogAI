/**
 * Error Handling Issues Test File
 * Contains error handling problems for DroogAI to detect
 */
public class ErrorHandlingIssues {
    
    // HIGH: Swallowed Exception
    public void processData(String data) {
        try {
            process(data);
        } catch (Exception e) {
            // Exception swallowed - no logging or handling
        }
    }
    
    // HIGH: Generic Exception Catch
    public void riskyOperation() {
        try {
            dangerousOperation();
        } catch (Exception e) {
            // Too generic - should catch specific exceptions
            logger.error("Error occurred");
        }
    }
    
    // MEDIUM: Missing Error Handling
    public void divideNumbers(int a, int b) {
        int result = a / b; // No check for division by zero
        // Should check if b == 0
    }
    
    // MEDIUM: Returning null instead of Optional
    public User findUser(Long id) {
        User user = database.getUser(id);
        return user; // Returns null if not found - should return Optional<User>
    }
    
    // LOW: Poor error messages
    public void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Error"); // Too vague
        }
    }
    
    // LOW: Exception in finally block
    public void cleanup() {
        try {
            // cleanup code
        } finally {
            closeResource(); // If this throws, original exception is lost
        }
    }
}

