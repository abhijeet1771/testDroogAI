package com.example.service;

/**
 * Service with breaking changes - will cause compilation/runtime failures
 */
public class BreakingChangesService {
    
    // BREAKING: Method signature changed (parameter added)
    // OLD: public void processData(String data)
    // NEW: public void processData(String data, String format)
    public void processData(String data, String format) {
        // Changed signature - will break callers
    }
    
    // BREAKING: Visibility reduced from public to private
    // OLD: public String getUserInfo(String userId)
    // NEW: private String getUserInfo(String userId)
    private String getUserInfo(String userId) {
        return "User: " + userId;
    }
    
    // BREAKING: Return type changed
    // OLD: public String getStatus()
    // NEW: public int getStatus()
    public int getStatus() {
        return 200;
    }
    
    // BREAKING: Method removed (commented out to show it existed)
    // public void oldMethod() { }
    
    // BREAKING: Parameter type changed
    // OLD: public void updateUser(Long userId)
    // NEW: public void updateUser(String userId)
    public void updateUser(String userId) {
        // Parameter type changed from Long to String
    }
}

