package com.user_management.crud_api.controllers;

import com.user_management.crud_api.exceptions.DuplicateResourceException;
import com.user_management.crud_api.exceptions.InvalidInputException;
import com.user_management.crud_api.exceptions.ResourceNotFoundException;
import com.user_management.crud_api.models.User;
import com.user_management.crud_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController implements UserApi {

    private final UserService userService;
    //Constructor Injection of Dependency
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
    	try {
    		 return ResponseEntity.ok(userService.getUserById(id));
    	}catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
       
    }

    @Override
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
        } catch (DuplicateResourceException e) { 
            return ResponseEntity.status(HttpStatus.CONFLICT) 
                                 .body(e.getMessage());
        } catch (InvalidInputException e) { 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST) // 400 Bad Request
                                 .body(e.getMessage());
        }
    }


    @Override
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.updateUser(id, user));
        } catch (ResourceNotFoundException e) { 
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(e.getMessage());
        } catch (DuplicateResourceException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body( e.getMessage());
        }
        catch(Exception e) {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body( e.getMessage());
        }
        
    }


    @Override
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("Deleted Successfully");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user");
        }
        
    }
}
