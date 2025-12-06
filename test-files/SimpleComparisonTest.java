package test.files;

/**
 * Simple test file to verify DroogAI compares PR against main branch
 * This file contains intentional issues for testing
 */
public class SimpleComparisonTest {
    
    // Issue 1: Missing null check
    public String processData(String data) {
        return data.toUpperCase(); // Potential NullPointerException
    }
    
    // Issue 2: Inefficient loop - O(n²) complexity
    public int findDuplicate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return array[i];
                }
            }
        }
        return -1;
    }
    
    // Issue 3: Magic number
    public boolean isValidAge(int age) {
        return age > 18 && age < 100; // Magic numbers
    }
    
    // Issue 4: No error handling
    public int divide(int a, int b) {
        return a / b; // No check for division by zero
    }
    
    // Issue 5: Hardcoded value
    public String getApiUrl() {
        return "https://api.example.com/v1"; // Should be configurable
    }
}

