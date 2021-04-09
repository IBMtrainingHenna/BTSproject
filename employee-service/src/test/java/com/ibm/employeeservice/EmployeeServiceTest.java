package com.ibm.employeeservice;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class EmployeeServiceTest {

	@Test
	void testCreateEmployee() {
		EmployeeService employeeService = new EmployeeService();
		EmployeeRepository dummyRepo = new DummyEmployeeRepository();
		employeeService.setEmployeerepository(dummyRepo);
		Employee employee = new Employee();
		String employeeId = employeeService.createEmployee(employee);
		assertNotNull(employee);
	}
	@Test
	void testGetEmployees() {
		EmployeeService employeeService = new EmployeeService();
		EmployeeRepository dummyRepo = new DummyEmployeeRepository();
		employeeService.setEmployeerepository(dummyRepo);
		Employee employee = new Employee();
		String employeeId = employeeService.createEmployee(employee);
		assertNotNull(employeeId);
	}
	
	@Test
	void testUpdateEmployee() {
		EmployeeService employeeService = new EmployeeService();
		EmployeeRepository dummyRepo = new DummyEmployeeRepository();
		employeeService.setEmployeerepository(dummyRepo);
		Employee employee = new Employee();
		
	}

}
