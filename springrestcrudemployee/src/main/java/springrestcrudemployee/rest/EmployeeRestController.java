package springrestcrudemployee.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springrestcrudemployee.entity.Employee;
import springrestcrudemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findStudent(@PathVariable int employeeId) {
		return employeeService.findById(employeeId);
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public void deleteById(@PathVariable int employeeId) {
		employeeService.deleteById(employeeId);
	}
}
