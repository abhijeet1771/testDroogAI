/**
 * Breaking Changes Test File
 * Contains breaking changes for DroogAI to detect
 */
public class BreakingChanges {
    
    // BREAKING: Method signature change (parameter added)
    // OLD: public User getUser(Long id)
    // NEW: public User getUser(Long id, boolean includeDeleted)
    public User getUser(Long id, boolean includeDeleted) {
        // This breaks existing callers
        return database.getUser(id, includeDeleted);
    }
    
    // BREAKING: Return type change
    // OLD: public List<User> getAllUsers()
    // NEW: public Set<User> getAllUsers()
    public Set<User> getAllUsers() {
        // Return type changed from List to Set - breaks callers
        return new HashSet<>(database.getAllUsers());
    }
    
    // BREAKING: Visibility change (public to private)
    // OLD: public void processData()
    // NEW: private void processData()
    private void processData() {
        // Visibility reduced - breaks external callers
    }
    
    // BREAKING: Method removed
    // OLD: public void oldMethod() { ... }
    // REMOVED - this will break callers
    
    // BREAKING: Parameter type change
    // OLD: public void updateUser(String userId)
    // NEW: public void updateUser(Long userId)
    public void updateUser(Long userId) {
        // Parameter type changed - breaks callers
    }
}

