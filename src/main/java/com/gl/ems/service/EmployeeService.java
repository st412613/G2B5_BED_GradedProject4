package com.gl.ems.service;

import java.util.List;
import java.util.Optional;
import com.gl.ems.entity.Employee;

public interface EmployeeService {
	List<Employee> findAllEmployee();
	Employee addEmployee(Employee employee);
	Optional<Employee> getEmployeeById(long id);
	void deleteEmployee(long id);
	Optional<Employee> updateEmployee(long id, Employee employee);
	//List<Employee> getEmployeeSortedByFirstNameAsc();
	List<Employee> getEmployeeCustomSortedByFirstName(String sort);
	List<Employee> findAllByName(String query);
	
	
	
	

}
