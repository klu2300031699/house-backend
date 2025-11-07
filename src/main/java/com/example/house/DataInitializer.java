package com.example.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if admin already exists
        Optional<UserEntity> existingAdmin = userRepository.findByEmail("2300031699@gmail.com");
        
        if (existingAdmin.isEmpty()) {
            // Create admin user
            UserEntity admin = new UserEntity();
            admin.setName("Admin");
            admin.setEmail("2300031699@gmail.com");
            admin.setPassword("gncgncgnc");
            admin.setPhone("0000000000");
            admin.setRole("admin");
            
            userRepository.save(admin);
            System.out.println("Admin user created successfully!");
        } else {
            System.out.println("Admin user already exists.");
        }
    }
}
