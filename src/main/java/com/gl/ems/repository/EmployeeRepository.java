package com.gl.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gl.ems.entity.Employee;
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//	List<Employee> findByOrderByFirstNameAsc();
//	List<Employee> findByOrderByFirstNameDesc();
	List<Employee> findAllByFirstName(String query);

}
