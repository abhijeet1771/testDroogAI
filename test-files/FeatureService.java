package com.example.feature;

import com.example.service.BreakingChangesService;

/**
 * Feature service that will be impacted
 * This represents a feature that will break
 */
public class FeatureService {
    
    private BreakingChangesService breakingService = new BreakingChangesService();
    
    // FEATURE WILL BREAK: User Management Feature
    // This feature depends on getUserInfo which is now private
    public void manageUser(String userId) {
        // WILL BREAK: Line 15
        String userInfo = breakingService.getUserInfo(userId); // Method is now private
        // Process user management
    }
    
    // FEATURE WILL BREAK: Data Processing Feature
    // This feature depends on processData with old signature
    public void processUserData(String data) {
        // WILL BREAK: Line 22
        breakingService.processData(data); // Missing format parameter
        // Process data
    }
    
    // FEATURE WILL BREAK: Status Checking Feature
    // This feature depends on getStatus returning String
    public void checkSystemStatus() {
        // WILL BREAK: Line 29
        String status = breakingService.getStatus(); // Returns int, not String
        if (status.equals("OK")) {
            // Process
        }
    }
}

