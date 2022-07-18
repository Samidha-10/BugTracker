package com.bug.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.tracking.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
