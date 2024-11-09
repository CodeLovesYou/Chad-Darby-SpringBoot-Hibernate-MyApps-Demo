package springrestcrudemployee.dao;

import java.util.List;

import springrestcrudemployee.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee employee);
	
	void deleteById(int theId);
}
