package test.files;

/**
 * Another test file to ensure DroogAI detects multiple files
 */
public class AnotherTestFile {
    
    // Duplicate code pattern (similar to SimpleComparisonTest)
    public String processData(String data) {
        return data.toLowerCase(); // Same pattern, different method
    }
    
    // Security issue: SQL injection risk
    public String buildQuery(String userId) {
        return "SELECT * FROM users WHERE id = " + userId; // SQL injection risk
    }
    
    // Performance issue: String concatenation in loop
    public String buildMessage(String[] parts) {
        String result = "";
        for (String part : parts) {
            result += part; // Should use StringBuilder
        }
        return result;
    }
}

