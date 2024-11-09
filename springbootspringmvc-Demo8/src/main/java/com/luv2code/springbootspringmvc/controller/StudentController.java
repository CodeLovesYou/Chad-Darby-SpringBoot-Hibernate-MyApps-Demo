package com.luv2code.springbootspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luv2code.springbootspringmvc.entity.Student;

@Controller
public class StudentController {
	
	@Value("${countries}")
	private List<String> countries;
	
	@Value("${languages}")
	private List<String> languages;

	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {
        // create a student object
        Student theStudent = new Student();

        // add student object to the model
        theModel.addAttribute("student", theStudent);
        
        //add countries to the model
        theModel.addAttribute("countries",countries);
        
        //add languages to the model
        theModel.addAttribute("languages", languages);
        
        return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processStudentForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("First Name: "+theStudent.getFirstName()
			+" Last Name: "+theStudent.getLastName()+" "+theStudent.getCountry());
		return "student-confirmation";
	}
}
