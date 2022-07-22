package com.bug.tracking.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.bug.tracking.modal.Bug;
import com.bug.tracking.modal.Employee;
import com.bug.tracking.modal.Project;
import com.bug.tracking.repository.EmployeeRepository;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class EmployeeServiceImplTest {
	@InjectMocks
	EmployeeServiceImpl employeeService;
	@Mock
	EmployeeRepository employeeRepositoryMock;
	@BeforeEach
	void setUp() throws Exception {
		Employee employee = new Employee(1L,"Ramprakash","Ram@gmail.com","Ram111","9898991234",new Bug(1L,"abcd","Big bug",new Project(1L,"SpringProject","Sp01","Abcd"),true));
		employeeRepositoryMock.save(employee);
	}

	@Test
	void test() {
		assertNotNull(employeeRepositoryMock.findAll());

	}
}
