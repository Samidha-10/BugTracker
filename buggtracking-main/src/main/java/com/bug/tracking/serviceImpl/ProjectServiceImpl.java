package com.bug.tracking.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracking.exception.ProjectIdException;
import com.bug.tracking.modal.Project;
import com.bug.tracking.repository.ProjectRepository;
import com.bug.tracking.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	@Override
	public Project addProject(Project project) {
		try{
			project.setId(project.getId());
			return projectRepository.save(project);
		}catch(Exception ex) {
			throw new ProjectIdException("Project Id : "+project.getId()+"already exists");
		}
		
	}
	@Override
	public Project findById(Long id) {
		Project project=projectRepository.findByProjectId(id);
		if(project == null)
			throw new ProjectIdException("Project Id " + id+" does not exist");
		return project;
	}
	
	@Override
	public List<Project> findAllProject() {
		return projectRepository.findAll();
	}
	@Override
	public void deleteProject(Long projectId) {
		Project project=projectRepository.findByProjectId(projectId);
		if(project == null)
			throw new ProjectIdException("Project Id " + projectId+" does not exist");
		projectRepository.delete(project);
		
	}
	

}

