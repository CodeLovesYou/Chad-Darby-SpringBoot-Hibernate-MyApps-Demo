package springrestcrudemployee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import springrestcrudemployee.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {

}
