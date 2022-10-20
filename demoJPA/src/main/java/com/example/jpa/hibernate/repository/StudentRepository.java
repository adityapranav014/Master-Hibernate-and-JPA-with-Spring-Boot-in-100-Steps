package com.example.jpa.hibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.hibernate.entity.Course;
import com.example.jpa.hibernate.entity.Passport;
import com.example.jpa.hibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	public Student save(Student student) {
		
		if(student.getId() == 0L) {
			em.persist(student);
		}else {
			em.merge(student);
		}
		return student;
	}
	
	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public void saveStudentWithPassport() {
		
		Passport passport = new Passport("Z123456");
		em.persist(passport);
		
		Student student = new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
	}
	
	public void someOperationToUnderstandPersistenceContext() {
		//Database Operation 1 - Retrieve student
		Student student = em.find(Student.class, 20001L);
		
		//Database Operation 2 - Retrieve passport
		Passport passport = student.getPassport();
		
		//Database Operation 3 - Update passport
		passport.setNumber("E123457");
		
		//Database Operation 4 - Update student
		student.setName("Ranga - updated");
	}
	
	public void insertHardcodedStudentAndCourse() {
		Student student = new Student("Jack");
		Course course = new Course("Microservices in 100 Steps");
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudent(student);
		em.persist(student);
	}
	
	public void insertStudentAndCourse(Student student, Course course) {
		
		student.addCourse(course);
		course.addStudent(student);
		
		em.persist(student);
		em.persist(course);
	}

}
