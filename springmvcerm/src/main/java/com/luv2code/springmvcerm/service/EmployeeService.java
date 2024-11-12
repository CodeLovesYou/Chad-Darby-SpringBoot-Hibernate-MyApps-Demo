package com.luv2code.springmvcerm.service;

import java.util.List;

import com.luv2code.springmvcerm.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee employee);
	
	void deleteById(int theId);
}
