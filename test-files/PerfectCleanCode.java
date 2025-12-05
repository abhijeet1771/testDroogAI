/**
 * Perfect Clean Code Example
 * This file should pass all DroogAI checks with zero issues
 * 
 * Features:
 * - Modern Java best practices
 * - Proper error handling
 * - Security best practices
 * - Performance optimized
 * - Well documented
 * - SOLID principles
 * - No code smells
 */
package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * User service with proper architecture and best practices.
 * 
 * @author DroogAI Test
 * @version 1.0
 */
public class PerfectCleanCode {
    
    /**
     * Thread-safe user storage using ConcurrentHashMap for O(1) lookups.
     */
    private final ConcurrentHashMap<Long, User> users = new ConcurrentHashMap<>();
    
    /**
     * Thread-safe ID generator using AtomicLong.
     */
    private final AtomicLong idGenerator = new AtomicLong(0);
    
    /**
     * Finds a user by ID using Optional for null safety.
     * 
     * @param id the user ID
     * @return Optional containing the user if found, empty otherwise
     */
    public Optional<User> findUserById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(users.get(id));
    }
    
    /**
     * Retrieves all users as an immutable list.
     * 
     * @return immutable list of all users
     */
    public List<User> getAllUsers() {
        return List.copyOf(users.values());
    }
    
    /**
     * Creates a new user with proper validation.
     * 
     * @param name the user's name (must not be blank)
     * @param email the user's email (must be valid format)
     * @return the created user
     * @throws IllegalArgumentException if validation fails
     */
    public User createUser(String name, String email) {
        validateUserInput(name, email);
        
        long newId = idGenerator.incrementAndGet();
        User user = new User(newId, name, email);
        users.put(newId, user);
        
        return user;
    }
    
    /**
     * Deletes a user by ID.
     * 
     * @param id the user ID to delete
     * @return true if user was deleted, false if not found
     */
    public boolean deleteUser(Long id) {
        if (id == null) {
            return false;
        }
        return users.remove(id) != null;
    }
    
    /**
     * Validates user input using modern Java String methods.
     * 
     * @param name the name to validate
     * @param email the email to validate
     * @throws IllegalArgumentException if validation fails
     */
    private void validateUserInput(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        
        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("Email must be valid");
        }
    }
    
    /**
     * Gets user names using Stream API.
     * 
     * @return list of user names
     */
    public List<String> getUserNames() {
        return users.values().stream()
                .map(User::name)
                .collect(Collectors.toList());
    }
    
    /**
     * User record - immutable data carrier using modern Java Records.
     * 
     * @param id the user ID
     * @param name the user's name
     * @param email the user's email
     */
    public record User(Long id, String name, String email) {
        /**
         * Validates user data.
         * 
         * @throws IllegalArgumentException if data is invalid
         */
        public User {
            if (id == null || id <= 0) {
                throw new IllegalArgumentException("ID must be positive");
            }
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be blank");
            }
            if (email == null || email.isBlank() || !email.contains("@")) {
                throw new IllegalArgumentException("Email must be valid");
            }
        }
    }
}

