public class PaymentService {
    
    // Method 1: Process payment without validation
    public double processPayment(double amount, String cardNumber) {
        // Missing validation - potential issues
        double fee = amount * 0.02; // Magic number
        return amount + fee;
    }
    
    // Method 2: Calculate discount with potential division by zero
    public double calculateDiscount(double price, int quantity) {
        // Missing null/zero check
        double discount = price / quantity; // Potential division by zero
        return price - discount;
    }
}



