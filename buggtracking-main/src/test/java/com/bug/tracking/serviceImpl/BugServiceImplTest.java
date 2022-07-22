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
import com.bug.tracking.repository.BugRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class BugServiceImplTest {
	@InjectMocks
	UserServiceImpl userService;
	@Mock
	BugRepository bugRepositoryMock;
	@BeforeEach
	void setUp() throws Exception {
		Bug bug = new Bug(1L,"","Big bug",new Project(1L,"SpringProject","Sp01","Abcd"),true);
		bugRepositoryMock.save(bug);
	}

	@Test
	void test() {
		assertNotNull(bugRepositoryMock.findAll());
	}

}
