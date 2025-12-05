/**
 * Documentation Issues Test File
 * Contains documentation problems for DroogAI to detect
 */
public class DocumentationIssues {
    
    // MISSING: No JavaDoc for public method
    public void processData(String data) {
        // Method has no documentation
    }
    
    // MISSING: No JavaDoc for class
    public class DataProcessor {
        // Class has no documentation
    }
    
    // POOR: Incomplete JavaDoc
    /**
     * Processes data
     */
    public void process(String input) {
        // Missing @param and @return documentation
    }
    
    // POOR: Outdated documentation
    /**
     * Gets user by ID
     * @param id the user ID
     * @return User object
     * @deprecated Use findUserById instead
     */
    public User getUser(Long id) {
        // Documentation says deprecated but method is still used
    }
}

