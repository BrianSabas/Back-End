package com.porfolio.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findById(Long id);

	User findByUsername(String username);
	
}
