package com.bugTracker.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugTracker.project.modal.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
