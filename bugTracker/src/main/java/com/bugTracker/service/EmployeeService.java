package com.bug.tracking.service;

import java.util.Optional;

import com.bug.tracking.model.Employee;

public interface EmployeeService {

	public Employee saveOrUpdate(Employee employee);
	public Optional<Employee> findEmployeeById(long userId);
	public Iterable<Employee> findAllEmployee();
	public void deleteEmployeeeById(Long id);
}
