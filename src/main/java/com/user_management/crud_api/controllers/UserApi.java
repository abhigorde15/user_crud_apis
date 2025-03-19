package com.user_management.crud_api.controllers;

import com.user_management.crud_api.exceptions.ResourceNotFoundException;
import com.user_management.crud_api.models.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;

//This interface has Controller Abstract Method and Their Swagger Api Documentation Descriptions
@RequestMapping("/api/users")
public interface UserApi {

	@GetMapping
	@Operation(summary = "Get all users", description = "Fetches all users from the database.")
	List<User> getAllUsers();

	@GetMapping("/{id}")
	@Operation(summary = "Get User by ID", description = "Fetches a user by ID.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "User found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
			@ApiResponse(responseCode = "404", description = "User not found") })
	ResponseEntity<?> getUserById(@PathVariable Long id);

	@PostMapping
	@Operation(summary = "Create a new user", description = "Adds a new user to the database.")
	@ApiResponses({
			@ApiResponse(responseCode = "201", description = "User created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input data"),
			@ApiResponse(responseCode = "409", description = "User Already Exist") })
	ResponseEntity<?> createUser(@Valid @RequestBody User user);

	@PutMapping("/{id}")
	@Operation(summary = "Update user", description = "Updates an existing user by ID.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "User updated", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
			@ApiResponse(responseCode = "404", description = "User not found") })
	ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody User user);

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete user", description = "Deletes a user from the database.")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "User deleted"),
			@ApiResponse(responseCode = "404", description = "User not found") })
	ResponseEntity<String> deleteUser(@PathVariable Long id);
}
