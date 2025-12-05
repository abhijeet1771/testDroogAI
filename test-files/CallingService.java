package com.example.service;

/**
 * Service that calls BreakingChangesService - WILL BREAK
 * This file will fail because it calls methods with changed signatures
 */
public class CallingService {
    
    private BreakingChangesService breakingService = new BreakingChangesService();
    
    // WILL BREAK: Calls processData with old signature (missing format parameter)
    public void processUserData(String data) {
        breakingService.processData(data); // BREAKING: Missing second parameter
    }
    
    // WILL BREAK: Calls getUserInfo which is now private
    public String fetchUser(String userId) {
        return breakingService.getUserInfo(userId); // BREAKING: Method is now private
    }
    
    // WILL BREAK: Expects String return type but now returns int
    public void checkStatus() {
        String status = breakingService.getStatus(); // BREAKING: Return type changed to int
        System.out.println(status);
    }
    
    // WILL BREAK: Calls updateUser with Long but now expects String
    public void updateUserAccount(Long userId) {
        breakingService.updateUser(userId); // BREAKING: Parameter type changed
    }
    
    // WILL BREAK: Calls removed method
    public void doSomething() {
        // breakingService.oldMethod(); // BREAKING: Method was removed
    }
}

