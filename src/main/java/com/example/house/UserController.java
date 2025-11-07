package com.example.house;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserEntity addUser(@RequestBody UserEntity user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully!";
    }

    // Register endpoint
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody UserEntity user) {
        Map<String, Object> response = new HashMap<>();
        
        UserEntity registeredUser = userService.registerUser(user);
        if (registeredUser == null) {
            response.put("success", false);
            response.put("message", "Email already exists!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        
        response.put("success", true);
        response.put("message", "Registration successful!");
        response.put("user", registeredUser);
        return ResponseEntity.ok(response);
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
        Map<String, Object> response = new HashMap<>();
        
        String email = credentials.get("email");
        String password = credentials.get("password");
        
        UserEntity user = userService.loginUser(email, password);
        if (user == null) {
            response.put("success", false);
            response.put("message", "Invalid credentials!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        
        response.put("success", true);
        response.put("message", "Login successful!");
        response.put("user", user);
        return ResponseEntity.ok(response);
    }
}
