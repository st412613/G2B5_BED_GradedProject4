package com.gl.ems.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ems.entity.Employee;
import com.gl.ems.service.EmployeeService;

@RestController // This is controller class for Employees
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
    //This API provides an endpoint to list all 
	//the employees stored in the database.
	@GetMapping("/employees") 
	public List<Employee> listOfEmployees() {
		return empService.findAllEmployee();

	}

	// This API provides endpoint to fetch or get
	// an employee record specifically based on the id of that employee-
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeesById(@PathVariable("id") long id) {
		Optional<Employee> emp = empService.getEmployeeById(id);
		return ResponseEntity.ok().body(emp);

	}
	//Now This API should be able to add employees data in the db
	//if and only if the authenticated user is ADMIN-
	@PostMapping("/employees/add") //ADD EMPLOYEE
	public Employee AddEmployee(@RequestBody Employee employee) {
		return empService.addEmployee(employee);

	}

	// This API provides an endpoint
	// to update an existing employee record with the given updated json object.
	@PutMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> updateEmployees(@PathVariable("id") long id,
			@RequestBody Employee employee) {
		Optional<Employee> emp = empService.updateEmployee(id, employee);
		return ResponseEntity.ok().body(emp);
	}

	// This API provides an endpoint
	// to delete an existing employee record based on the id of the employee-
	@DeleteMapping("/employees/{id}")
	public String deleteById(@PathVariable("id") long id) {
		empService.deleteEmployee(id);
		return "Deleted Employees id " + id;

	}

	// This API able to list all employee records sorted on their first name in
	// either
	// ascending order or descending order .
	@GetMapping("/employees/sort")
	public List<Employee> sortListOfEmployees(@RequestParam("order") String sort) {
		return empService.getEmployeeCustomSortedByFirstName(sort);
	}

	// This API provides an endpoint
	// to fetch an employee by his/her first name
	// and if found more than one record then list them all-
	@GetMapping("/employees/search")

	public List<Employee> searchEmployees(@RequestParam("query") String query) {
		return empService.findAllByName(query);
	}

}
