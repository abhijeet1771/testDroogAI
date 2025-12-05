package test.files;

/**
 * SafeService - POSITIVE SCENARIO
 * This service demonstrates safe, non-breaking changes
 * All changes here are backward compatible
 */
public class SafeService {
    
    /**
     * POSITIVE: Method signature unchanged (safe)
     * This method is called from master but we're not changing it
     */
    public String getData(String id) {
        return "Data for: " + id;
    }
    
    /**
     * POSITIVE: New method added (safe, non-breaking)
     * Adding new methods doesn't break existing code
     */
    public String getDataWithDetails(String id, boolean includeMetadata) {
        String data = getData(id);
        if (includeMetadata) {
            return data + " [with metadata]";
        }
        return data;
    }
    
    /**
     * POSITIVE: Method improved but signature same (safe)
     * Internal implementation changed but API unchanged
     */
    public int calculateTotal(int a, int b) {
        // Implementation improved but signature same
        // This is safe - no breaking changes
        return a + b;
    }
    
    /**
     * POSITIVE: New helper method (safe)
     */
    private String formatData(String data) {
        return "[" + data + "]";
    }
}

