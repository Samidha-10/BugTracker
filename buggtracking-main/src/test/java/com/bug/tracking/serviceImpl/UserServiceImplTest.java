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
import com.bug.tracking.modal.Project;
import com.bug.tracking.modal.UserEntity;
import com.bug.tracking.repository.UserRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userService;
	@Mock
	UserRepository userRepositoryMock;
	@BeforeEach
	void setUp() throws Exception {
		UserEntity user = new UserEntity(1L,"Ramprakash","Ram1234","Ram@gmail.com",new Bug(1l,"abcd","Big bug",new Project(1L,"SpringProject","Sp01","Abcd"),true));
		userRepositoryMock.save(user);
	}

	@Test
	void test() {
		assertNotNull(userRepositoryMock.findAll());

	}

}
