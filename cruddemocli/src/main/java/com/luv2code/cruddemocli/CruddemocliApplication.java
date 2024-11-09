package com.luv2code.cruddemocli;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemocli.dao.StudentDAO;
import com.luv2code.cruddemocli.entity.Student;

@SpringBootApplication
public class CruddemocliApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemocliApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
			createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//updateStudent(studentDAO);
			//updateStudents(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}
	
	private void deleteAllStudents(StudentDAO studentDAO) {
		String lastName = "Tester";
		System.out.println("Deleting Students...");
		int numRowsUpdated =  studentDAO.deleteByLastName(lastName);
		System.out.println("Rows Updated: "+numRowsUpdated);
		System.out.println("Students Deleted...");
	}
	
	private void deleteStudent(StudentDAO studentDAO) {
		int id = 3;
		System.out.println("Deleting student...");
		studentDAO.delete(id);
		System.out.println("Deleted Student...");
	}
	private void updateStudents(StudentDAO studentDAO) {
		System.out.println("Updating all students....");
		studentDAO.updateAllStudents();
		System.out.println("Updated all students....");
	}
	
	private void updateStudent(StudentDAO studentDAO) {
		int id=1;
		System.out.println("Getting student with Id: "+id);
		Student myStudent = studentDAO.findById(id);
		
		System.out.println("Updating Student...");
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);
		System.out.println("Updated Student: "+myStudent);
	}
	
	private void readStudent(StudentDAO studentDAO) {
		
		//create a student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");
		
		System.out.println("saving the object");
		studentDAO.save(tempStudent);
		
		System.out.println("Saved Student: "+tempStudent.getId());
		System.out.println("Retrieving Student: "+tempStudent.getId());
		
		Student myStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("Found the student: "+myStudent);
	}
	
	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating student objects..");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");
		
		System.out.println("Saving students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
	
	private void createStudent(StudentDAO studentDAO) {
		
		System.out.println("Creating student object...");
		Student tempStudent = new Student("padau","bh","padau@luv2code.com");
		
		System.out.println("Saving student object");
		studentDAO.save(tempStudent);
		
		System.out.println("Save Student. Generated Id: "+tempStudent.getId());
	}
	
	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		
		for(Student theStudent:students) {
			System.out.println(theStudent);
		}
	}

}
