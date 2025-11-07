package com.example.house;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public UserEntity addUser(UserEntity user) {
        return repository.save(user);
    }

    public UserEntity updateUser(Long id, UserEntity newUser) {
        UserEntity existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(newUser.getName());
            existing.setEmail(newUser.getEmail());
            existing.setPhone(newUser.getPhone());
            existing.setPassword(newUser.getPassword());
            existing.setRole(newUser.getRole());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    // Register new user
    public UserEntity registerUser(UserEntity user) {
        // Check if user already exists
        Optional<UserEntity> existingUser = repository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return null; // Email already exists
        }
        // Set default role as "user" if not specified
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("user");
        }
        return repository.save(user);
    }

    // Login user
    public UserEntity loginUser(String email, String password) {
        Optional<UserEntity> user = repository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null; // Invalid credentials
    }
}

