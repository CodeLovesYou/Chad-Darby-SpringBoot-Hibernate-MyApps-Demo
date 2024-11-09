package com.luv2code.cruddemocli.dao;

import java.util.List;

import com.luv2code.cruddemocli.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	void update(Student theStudent);
	
	int updateAllStudents();
	
	void delete(Integer id);
	
	int deleteByLastName(String lastName);
}
