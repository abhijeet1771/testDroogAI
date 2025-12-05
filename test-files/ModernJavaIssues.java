/**
 * Modern Java Issues Test File
 * Contains code that should use modern Java features
 */
import java.util.*;

public class ModernJavaIssues {
    
    // ISSUE: Should use Stream API instead of loop
    public List<String> getNames(List<User> users) {
        List<String> names = new ArrayList<>();
        for (User user : users) {
            names.add(user.getName());
        }
        return names;
        // Should use: users.stream().map(User::getName).toList()
    }
    
    // ISSUE: Should use Optional instead of null
    public User findUser(Long id) {
        User user = database.getUser(id);
        return user; // Returns null - should return Optional<User>
    }
    
    // ISSUE: Should use Record instead of class
    public class UserData {
        private final Long id;
        private final String name;
        private final String email;
        
        public UserData(Long id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }
        // Should be: record UserData(Long id, String name, String email) {}
    }
    
    // ISSUE: Should use immutable collections
    public List<String> getConstants() {
        List<String> constants = new ArrayList<>();
        constants.add("CONST1");
        constants.add("CONST2");
        return constants;
        // Should use: List.of("CONST1", "CONST2")
    }
    
    // ISSUE: Should use modern String methods
    public boolean isEmpty(String str) {
        return str == null || str.length() == 0;
        // Should use: str == null || str.isBlank()
    }
    
    // ISSUE: Should use var for local variables
    public void processData() {
        String veryLongVariableName = getData();
        // Should use: var veryLongVariableName = getData();
    }
}

