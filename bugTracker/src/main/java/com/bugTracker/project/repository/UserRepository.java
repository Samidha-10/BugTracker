package com.bugTracker.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bugTracker.project.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
