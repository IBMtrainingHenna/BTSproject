package com.ibm.bugBts;

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
public class BugController {
	@Autowired
	BugService bugService;

	@PostMapping("/bug")
	String createBug(@RequestBody @Valid Bug bug, BindingResult bindingResult) {
		validateModel(bindingResult);
		return bugService.createBug(bug);
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong. Plesae retry");
		}
	}

	@GetMapping("/bug")
	List<Bug> getBugs() {
		return bugService.getBugs();
	}

	@GetMapping("/bug/{id}")
	Optional<Bug> getBug(@PathVariable("id") String bugId) {
		return bugService.getBug(bugId);
	}

	@PutMapping("/bug/{id}")
	void updateProject(@PathVariable("id") String bugId, @RequestBody Bug bug, BindingResult bindingResult) {
		validateModel(bindingResult);
		bug.setId(bugId);
		bugService.updateBug(bug);
	}

}
