package com.ibm.projectbts;

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

}
