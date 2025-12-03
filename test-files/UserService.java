import java.util.List;
import java.util.ArrayList;

public class UserService {
    
    private List<User> users = new ArrayList<>();
    
    public User findUserById(Long id) {
        // Missing null check, missing test
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null; // Should use Optional
    }
    
    public List<User> getAllUsers() {
        // Missing test
        return users;
    }
    
    public User createUser(String name, String email) {
        // Missing validation, missing test
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        users.add(user);
        return user;
    }
    
    public void deleteUser(Long id) {
        // Critical method with no test
        users.removeIf(user -> user.getId().equals(id));
    }
}

class User {
    private Long id;
    private String name;
    private String email;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

