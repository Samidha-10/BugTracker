package com.bug.tracking.repository;

import com.bug.tracking.model.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	void deleteById(Optional<Employee> user);
}
