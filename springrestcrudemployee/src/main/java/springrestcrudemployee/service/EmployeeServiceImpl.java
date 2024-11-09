package springrestcrudemployee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springrestcrudemployee.dao.EmployeeDAO;
import springrestcrudemployee.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}


	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}


	@Override
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
	}


	@Override
	@Transactional
	public Employee save(Employee employee) {
		
		return employeeDAO.save(employee);
	}
	
	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}
