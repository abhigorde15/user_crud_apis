package com.user_management.crud_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.user_management.crud_api.exceptions.DuplicateResourceException;
import com.user_management.crud_api.exceptions.ResourceNotFoundException;
import com.user_management.crud_api.models.User;
import com.user_management.crud_api.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@Service
@Validated
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
    	return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));
    }

    @Transactional
    public User createUser(@Valid User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateResourceException("User with email " + user.getEmail() + " already exists");
        }
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long id, @Valid User userDetails) {
    	User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));

        // Ensure email is unique before updating
        if (!existingUser.getEmail().equals(userDetails.getEmail()) &&
            userRepository.findByEmail(userDetails.getEmail()).isPresent()) {
            throw new DuplicateResourceException("User with email " + userDetails.getEmail() + " already exists");
        }

        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setAge(userDetails.getAge());

        return userRepository.save(existingUser);
    }

    @Transactional
    public boolean deleteUser(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));
        
        try {
            userRepository.delete(existingUser);
            return true;  
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user: " + e.getMessage());
        }
    }

   
}