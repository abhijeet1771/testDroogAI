/**
 * Code Smells Test File
 * Contains various code smells for DroogAI to detect
 */
public class CodeSmells {
    
    // SMELL: God Object - too many responsibilities
    public class UserManager {
        public void createUser() { }
        public void deleteUser() { }
        public void sendEmail() { } // Should be in EmailService
        public void processPayment() { } // Should be in PaymentService
        public void generateReport() { } // Should be in ReportService
        public void validateData() { } // Should be in Validator
        // Too many responsibilities - violates Single Responsibility Principle
    }
    
    // SMELL: Long Method - too many lines
    public void processOrder(Order order) {
        // 50+ lines of code
        validateOrder(order);
        checkInventory(order);
        calculateTax(order);
        applyDiscount(order);
        processPayment(order);
        updateInventory(order);
        sendConfirmation(order);
        logTransaction(order);
        updateAnalytics(order);
        notifyWarehouse(order);
        // Should be broken into smaller methods
    }
    
    // SMELL: Magic Numbers
    public double calculateDiscount(double price) {
        return price * 0.15; // Magic number - should be a constant
    }
    
    // SMELL: Dead Code
    public void unusedMethod() {
        // This method is never called
        System.out.println("Never executed");
    }
    
    // SMELL: Feature Envy - accesses other object's data too much
    public class OrderProcessor {
        public void process(Order order) {
            String customerName = order.getCustomer().getName();
            String customerEmail = order.getCustomer().getEmail();
            String customerAddress = order.getCustomer().getAddress();
            // Should delegate to Order or Customer class
        }
    }
    
    // SMELL: Primitive Obsession
    public void createUser(String name, String email, String phone, String address) {
        // Should use User object instead of primitives
    }
}

