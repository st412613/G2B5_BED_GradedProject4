package com.gl.ems.service.Impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gl.ems.entity.Employee;
import com.gl.ems.repository.EmployeeRepository;
import com.gl.ems.service.EmployeeService;



@Service
public  class EmployeeServiceImpl implements EmployeeService {
	private static final String Asc = null;
	@Autowired
	private EmployeeRepository empRepo;

	

//	public EmployeeServiceImpl(EmployeeRepository empRepo) {
//
//		this.empRepo = empRepo;
//	}

	@Override
	public List<Employee> findAllEmployee() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		return empRepo.save(employee);
	}

	
	@Override
	public Optional<Employee> getEmployeeById(long id) { 
		
		return empRepo.findById(id);
		
	}

	@Override
	 public Optional<Employee> updateEmployee(long id, Employee employee) {
        if (empRepo.findById(id).isPresent()){
            Employee existingEmp = empRepo.findById(id).get();
            existingEmp.setFirstName(employee.getFirstName());
            existingEmp.setLastName(employee.getLastName());
            existingEmp.setEmail(employee.getEmail());
            Employee updatedEmployee = empRepo.save(existingEmp);
            return Optional.of(updatedEmployee);
        }else{
            return Optional.empty();
        }
	}

	@Override
	public void deleteEmployee(long id) {
		empRepo.deleteById(id);

	}





//	@Override
//	public List<Employee> getEmployeeSortedByFirstNameAsc() {
//		return empRepo.findAll(Sort.by(Sort.Direction.ASC,"firstName"));
//		
//	}

	@Override
	public List<Employee> getEmployeeCustomSortedByFirstName(String sort) {
		
		return	empRepo.findAll(Sort.by(Sort.Direction.fromString(sort),"firstName"));	
		//}
		//else if(sort.equals("desc")) {
		//	return empRepo.findByOrderByFirstNameDesc();
		//}
		//else {
		//return	empRepo.findAll();
		//}
	}

	@Override
	public List<Employee> findAllByName(String query) {
		return empRepo.findAllByFirstName(query);
	
	}

	


}
