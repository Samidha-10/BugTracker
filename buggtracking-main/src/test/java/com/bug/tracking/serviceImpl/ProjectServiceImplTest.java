package com.bug.tracking.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.bug.tracking.modal.Project;
import com.bug.tracking.repository.ProjectRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ProjectServiceImplTest {
	@InjectMocks
	ProjectServiceImpl projectService;
	@Mock
	ProjectRepository projectRepositoryMock;
	Project p1,p2,p3;
	
	@BeforeEach
	void setUp() throws Exception {
		p1= new Project();
		p1.setId(1l);
		p1.setProjectName("SpringProject");
		p1.setProjectIdentifier("SP01");
		p1.setDescription("good Project");
		p2= new Project();
		p2.setId(2l);
		p2.setProjectName("SpringProject02");
		p2.setProjectIdentifier("Sp02");
		p2.setDescription("good Project as well");
		p3= new Project();
		p3.setId(3l);
		p3.setProjectName("SpringStartter");
		p3.setProjectIdentifier("Sp03");
		p3.setDescription("good Project");
		projectRepositoryMock.save(p1);
		projectRepositoryMock.save(p2);
		projectRepositoryMock.save(p3);
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull(projectRepositoryMock.findAll());
	}
//	@Test
//	void testFindById() {
//		System.out.println(p1.getProjectName());
//		when(projectRepositoryMock.findById(1L)).thenReturn(Optional.of(p1));
//		assertEquals("SpringProject02", projectService.findById(1l).thenReturn(Optional.of(p1)));
////		Project project1=projectService.getProject;
//		Exception exception = assertThrows(ProjectIdException.class, () -> projectService.findProjectByIdentifier("Sp000"));
//		assertTrue(exception.getMessage().contains("There are no project having id:11"));
//
//	
//	}

//	@Test
//	void testDeleteProjectByProjectIdentifier() {
//		
//	}

}