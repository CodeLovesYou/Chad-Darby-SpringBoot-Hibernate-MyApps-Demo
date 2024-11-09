package springrestcrudemployee.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import springrestcrudemployee.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = entityManager
				.createQuery("from Employee",Employee.class);
		return query.getResultList();
	}
	
	@Override
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public Employee save(Employee employee) {
		
		return entityManager.merge(employee);
	}

	@Override
	public void deleteById(int theId) {
		
		Employee dbEmployee = entityManager.find(Employee.class, theId);
		
		entityManager.remove(dbEmployee);
	}
}
