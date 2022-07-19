package com.bug.tracking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.tracking.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	void deleteById(Optional<User> user);

}
