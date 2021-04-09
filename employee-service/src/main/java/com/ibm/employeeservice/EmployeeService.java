package com.ibm.employeeservice;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public String createEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee.getId();
	}
	
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployee(String employeeId) {
		return employeeRepository.findById(employeeId);
	}

	public void updateEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}

	public void setEmployeerepository( EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
 

}
