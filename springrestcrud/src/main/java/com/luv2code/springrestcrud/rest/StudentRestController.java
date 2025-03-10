package com.luv2code.springrestcrud.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springrestcrud.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	@PostConstruct
	private void loadData(){
		
		theStudents = new ArrayList<>();
		theStudents.add(new Student("David","Jerico"));
		theStudents.add(new Student("Devika","Rani"));
		theStudents.add(new Student("Rohit","Shetty"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if(studentId >=theStudents.size() || studentId <0) {
			throw new StudentNotFoundException("student id not found: "+studentId);
		}
		return theStudents.get(studentId);
	}
	

}
