package com.luv2code.springmvcerm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springmvcerm.entity.Employee;
import com.luv2code.springmvcerm.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get the employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
    
    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel) {
    	
    	Employee theEmployee = new Employee();
    	
    	theModel.addAttribute("employee",theEmployee);
    	
    	return "/employees/employee-form";
    }
    
    @PostMapping("/save")
    public String processForm(
    		@ModelAttribute("employee") Employee theEmployee) {
    	employeeService.save(theEmployee);
    	return "redirect:/employees/list";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,
    			Model theModel) {
    	
    	Employee theEmployee = employeeService.findById(id);
    	
    	theModel.addAttribute("employee", theEmployee);
    	
    	return "employees/employee-form";
    }
}

