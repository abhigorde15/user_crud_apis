package com.user_management.crud_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user_management.crud_api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

}
