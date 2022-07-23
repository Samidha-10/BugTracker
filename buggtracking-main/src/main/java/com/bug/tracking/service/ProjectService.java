package com.bug.tracking.service;

import java.util.List;


import com.bug.tracking.modal.Project;

public interface ProjectService {
public Project addProject(Project project);
public Project findById(Long projectId);

public List<Project> findAllProject();
public void deleteProject(Long projectId);
}
