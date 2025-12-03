public class Calculator {
    // Simple calculator with potential issues for AI to find
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        // Potential issue: no overflow check
        return a * b;
    }
    
    public double divide(int a, int b) {
        // Potential issue: no division by zero check
        return a / b;
    }
    
    public String process(String input) {
        // Potential null pointer - AI should catch
        return input.toUpperCase();
    }
}

