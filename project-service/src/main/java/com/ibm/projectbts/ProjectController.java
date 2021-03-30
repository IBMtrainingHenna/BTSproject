package com.ibm.projectbts;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
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

}
