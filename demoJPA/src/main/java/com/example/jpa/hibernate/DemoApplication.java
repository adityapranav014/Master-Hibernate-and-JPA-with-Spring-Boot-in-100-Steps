package com.example.jpa.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.hibernate.entity.Course;
import com.example.jpa.hibernate.entity.FullTimeEmployee;
import com.example.jpa.hibernate.entity.PartTimeEmployee;
import com.example.jpa.hibernate.entity.Review;
import com.example.jpa.hibernate.entity.Student;
import com.example.jpa.hibernate.repository.CourseRepository;
import com.example.jpa.hibernate.repository.EmployeeRepository;
import com.example.jpa.hibernate.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		studentRepository.saveStudentWithPassport();
//		Course course = repository.findById(10001L);
//		logger.info("Course 10001 -> {}", course);
//		repository.save(new Course("Microservices in 100 Steps"));
//		repository.deleteById(10001L);
//		courseRepository.addHardcodedReviewsForCourse();
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("5", "Great Hands-on Stuff."));
//		reviews.add(new Review("5", "Hatsoff."));
//		courseRepository.addReviewsForCourse(10003L, reviews);
//		studentRepository.insertHardcodedStudentAndCourse();
		
//		studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 Steps"));
		
//		employeeRepository.insert( new PartTimeEmployee("Jill", new BigDecimal("50")));
//		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
		
//		logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees());
		
//		logger.info("Full Time Employees -> {}", employeeRepository.retrieveAllFullTimeEmployee());		
//		logger.info("Part Time Employees -> {}", employeeRepository.retrieveAllPartTimeEmployee());
		
	}

}
