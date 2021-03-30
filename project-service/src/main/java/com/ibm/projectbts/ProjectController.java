package com.ibm.projectbts;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService;

	/**
	 * creates project
	 * 
	 * @param project
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/project")
	String createProject(@RequestBody @Valid Project project, BindingResult bindingResult) {
		validateModel(bindingResult);
		return projectService.createProject(project);
	}

	@GetMapping("/project")
	List<Project> getProject() {
		return projectService.getProject();
	}

	/**
	 * method to obtain single project details
	 *
	 * @param projectId
	 * @return project details
	 */
	@GetMapping("/project/{id}")
	Optional<Project> getProject(@PathVariable("id") String projectId) {
		return projectService.getProject(projectId);
	}

	/**
	 * validation
	 * 
	 * @param bindingResult
	 */
	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong. Plesae retry");
		}
	}

	/**
	 * updates project details
	 *
	 * @param projectId
	 * @param project
	 * @param bindingResult
	 */
	@PutMapping("/project/{id}")
	void updateProject(@PathVariable("id") String projectId, @RequestBody Project project,
			BindingResult bindingResult) {
		validateModel(bindingResult);
		project.setId(projectId);
		projectService.updateProject(project);
	}

}
