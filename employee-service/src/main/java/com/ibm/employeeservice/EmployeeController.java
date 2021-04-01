package com.ibm.employeeservice;


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
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	String createEmployee(@RequestBody @Valid Employee employee, BindingResult bindingResult ) {
		validateModel(bindingResult);
		return employeeService.createEmployee(employee);
	}
	
	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong. Plesae retry");
		}
	}
	
	@GetMapping("/employee")
	List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employee/{id}")
	Optional<Employee> getEmployee(@PathVariable("id") String employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@PutMapping("/employee/{id}")
	void updateProject(@PathVariable("id") String employeeId, @RequestBody Employee employee, BindingResult bindingResult) {
		validateModel(bindingResult);
		employee.setId(employeeId);
		employeeService.updateEmployee(employee);
	}

}


