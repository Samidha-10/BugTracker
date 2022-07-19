package com.bug.tracking.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracking.execption.EmployeeEmailException;
import com.bug.tracking.execption.EmployeeIdException;
import com.bug.tracking.model.Employee;
import com.bug.tracking.repository.EmployeeRepo;
import com.bug.tracking.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepository;
	
	@Override
	public Employee saveOrUpdate(Employee employee) {
		try{
			employee.setEmail(employee.getEmail().toUpperCase());
			return employeeRepository.save(employee);
		}catch(Exception ex) {
			throw new EmployeeEmailException("Employee with email : "+employee.getEmail().toUpperCase()+"already exists");
		}
	}
	
	@Override
	public Optional<Employee> findEmployeeById(long employeeId) {
		Optional<Employee> employee=employeeRepository.findById(employeeId);
		if(employee == null)
			throw new EmployeeEmailException("Employee Id " + employeeId +" does not exist");
		return employee;
	}
	
	@Override
	public Iterable<Employee> findAllEmployee(){
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployeeeById(Long id) {
		Optional<Employee> user = employeeRepository.findById(id);
		if(user ==null)
			throw new EmployeeIdException("User Id " + id + "does not exist");
		employeeRepository.deleteById(user);
		
	}
}
