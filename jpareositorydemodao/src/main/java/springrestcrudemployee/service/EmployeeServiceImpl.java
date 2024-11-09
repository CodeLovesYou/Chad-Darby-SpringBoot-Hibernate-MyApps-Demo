package springrestcrudemployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import springrestcrudemployee.dao.EmployeeDAO;
import springrestcrudemployee.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeDAO employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = null;
		if(result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("Did not find employee id: "+id);
		}
		return employee;
	}


	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);;
	}


	



}
