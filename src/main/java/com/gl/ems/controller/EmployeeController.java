package com.gl.ems.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ems.entity.Employee;
import com.gl.ems.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	@GetMapping("/employees")
	public List<Employee> listOfEmployees() {
		return empService.findAllEmployee();
		
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeesById(@PathVariable("id") long id) {
		Optional<Employee> emp = empService.getEmployeeById(id);
		return ResponseEntity.ok().body(emp);
		
	}
	@PostMapping("/employees/add")
	public Employee AddEmployee(@RequestBody Employee employee) {
		return empService.addEmployee(employee);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> updateEmployees(@PathVariable("id") long id,@RequestBody Employee employee) {
		Optional<Employee> emp = empService.updateEmployee(id,employee);
		return ResponseEntity.ok().body(emp);
		
	}
	@DeleteMapping("/employees/{id}")
	public String deleteById(@PathVariable("id") long id ) {
		empService.deleteEmployee(id);
		return "Deleted Employees id "+id;
		
	}
//	@GetMapping("/employees/sortByFirstName")
//	public List<Employee> listOfEmployeesAsc(){
//		return empService.getEmployeeSortedByFirstNameAsc();
//		}
	
	@GetMapping("/employees/sort")
	public List<Employee> sortListOfEmployees(@RequestParam("order") String sort){
		return empService.getEmployeeCustomSortedByFirstName(sort);
		}
	@GetMapping("/employees/search")
	public List<Employee> searchEmployees(@RequestParam("query") String query){
		return empService.findAllByName(query);
		}

	}

