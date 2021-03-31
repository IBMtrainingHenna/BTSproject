package com.ibm.projectbts;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	@Transactional
	public String createProject(Project project) {
		Project savedProject = projectRepository.save(project);
		if (project != null)
			throw new RuntimeException();
		return savedProject.getId();
	}

	public void updateProject(@RequestBody Project project) {
		projectRepository.save(project);
	}

	public List<Project> getProject() {
		return projectRepository.findAll();
	}

	public Optional<Project> getProject(String projectId) {
		return projectRepository.findById(projectId);
	}

}
