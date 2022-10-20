package com.example.jpa.hibernate.repository;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.hibernate.DemoApplication;
import com.example.jpa.hibernate.entity.Address;
import com.example.jpa.hibernate.entity.Passport;
import com.example.jpa.hibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
class StudentRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
		
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	public void someTest() {
		repository.someOperationToUnderstandPersistenceContext();
	}
	
	@Test
	@Transactional
	void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
	
	@Test
	@Transactional
	void setAddressDetails() {
		Student student = em.find(Student.class, 20001L);
		student.setAddress(new Address("No 101", "Some Street", "Hyderabad"));
		em.flush();
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
	
	@Test
	@Transactional
	void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}
	
	@Test
	@Transactional
	void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("courses -> {}", student.getCourses());
	}
}
