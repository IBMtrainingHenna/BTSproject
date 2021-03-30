package com.ibm.projectbts;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	public String createProject(Project project) {
		Project savedProject = projectRepository.save(project);
		return savedProject.getId();
	}
	public List<Project> getProject() {
		return projectRepository.findAll();
		}

		public Optional<Project> getProject(String projectId) {
		return projectRepository.findById(projectId);
		}

}
