package com.example.house;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
            return repository.save(existing);
        }
        return null;
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}

