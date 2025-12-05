/**
 * Observability Issues Test File
 * Contains observability problems for DroogAI to detect
 */
public class ObservabilityIssues {
    
    // HIGH: Missing Error Logging
    public void processPayment(Payment payment) {
        try {
            process(payment);
        } catch (Exception e) {
            // No logging - errors are invisible
            throw new RuntimeException(e);
        }
    }
    
    // MEDIUM: Missing Logging at Entry/Exit
    public void importantOperation() {
        // No log at method entry
        // ... operation code ...
        // No log at method exit
    }
    
    // MEDIUM: Poor Logging Quality
    public void processOrder(Order order) {
        logger.info("Processing"); // Too vague - should include order ID
    }
    
    // LOW: Missing Metrics
    public void processRequest(Request request) {
        // No metrics for request count, latency, errors
        process(request);
    }
    
    // LOW: Missing Distributed Tracing
    public void callExternalService() {
        // No trace ID propagation
        externalService.call();
    }
}

