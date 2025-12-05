/**
 * Performance Issues Test File
 * Contains performance bottlenecks for DroogAI to detect
 */
import java.util.*;

public class PerformanceIssues {
    
    // HIGH: O(n²) complexity - nested loops
    public List<String> findDuplicates(List<String> list) {
        List<String> duplicates = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    duplicates.add(list.get(i));
                }
            }
        }
        return duplicates;
        // Should use Set for O(n) complexity
    }
    
    // HIGH: N+1 Query Problem
    public List<Order> getOrdersWithUsers(List<Long> orderIds) {
        List<Order> orders = new ArrayList<>();
        for (Long orderId : orderIds) {
            Order order = database.getOrder(orderId);
            // N+1 problem - fetching user for each order
            User user = database.getUser(order.getUserId());
            order.setUser(user);
            orders.add(order);
        }
        return orders;
        // Should use JOIN query to fetch all at once
    }
    
    // MEDIUM: String concatenation in loop
    public String buildMessage(List<String> parts) {
        String message = "";
        for (String part : parts) {
            message += part; // Creates new String object each iteration
        }
        return message;
        // Should use StringBuilder
    }
    
    // MEDIUM: Inefficient collection usage
    public boolean containsUser(List<User> users, Long userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return true;
            }
        }
        return false;
        // Should use Map or Set for O(1) lookup
    }
    
    // LOW: Unnecessary object creation
    public void processItems(List<Item> items) {
        for (Item item : items) {
            String processed = new String(item.getName()); // Unnecessary
            // ...
        }
    }
    
    // LOW: Missing caching opportunity
    public ExpensiveData getExpensiveData(Long id) {
        // Always fetches from database - should cache
        return database.fetchExpensiveData(id);
    }
}

