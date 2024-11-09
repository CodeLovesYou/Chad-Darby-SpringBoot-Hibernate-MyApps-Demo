package com.luv2code.cruddemocli.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.cruddemocli.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

	private EntityManager entityManager;
	
	
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}
	
	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}
	
	@Override
	public List<Student> findAll(){
		TypedQuery<Student> theQuery = entityManager.createQuery
				("from Student",Student.class);
		return theQuery.getResultList();
	}
	
	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}
	
	@Override
	@Transactional
	public int updateAllStudents() {
		return entityManager.createQuery
				("UPDATE Student set lastName='Tester'")
				.executeUpdate();
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Student myStudent = entityManager.find(Student.class,id);
		entityManager.remove(myStudent);
	}

	@Override
	@Transactional
	public int deleteByLastName(String lastName) {
		int numRowsUpdated = entityManager.createQuery(
				"delete from Student where lastName='"+lastName+"'")
				.executeUpdate();
		
		return numRowsUpdated;
	}
	
	

}
