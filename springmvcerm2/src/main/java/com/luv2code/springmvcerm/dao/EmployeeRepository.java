package com.luv2code.springmvcerm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springmvcerm.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
