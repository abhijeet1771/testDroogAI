/**
 * Architecture Violations Test File
 * Contains architecture rule violations for DroogAI to detect
 */
import java.sql.*; // Should not import SQL in service layer

public class ArchitectureViolations {
    
    // VIOLATION: Direct database access in service layer
    public void getUserData(Long id) {
        Connection conn = DriverManager.getConnection("jdbc:...");
        // Should use repository/DAO pattern
    }
    
    // VIOLATION: Circular dependency risk
    public class ServiceA {
        private ServiceB serviceB;
    }
    
    public class ServiceB {
        private ServiceA serviceA; // Circular dependency
    }
    
    // VIOLATION: Wrong package structure
    // This class is in wrong package - violates module isolation
    
    // VIOLATION: Naming convention
    public void ProcessData() {
        // Method name should be camelCase: processData()
    }
    
    // VIOLATION: Public field
    public String publicField; // Should be private with getter/setter
}

