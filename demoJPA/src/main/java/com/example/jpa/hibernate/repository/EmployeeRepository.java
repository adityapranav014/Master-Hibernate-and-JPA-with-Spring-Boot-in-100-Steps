package com.example.jpa.hibernate.repository;


import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.jpa.hibernate.entity.Course;
import com.example.jpa.hibernate.entity.Employee;
import com.example.jpa.hibernate.entity.FullTimeEmployee;
import com.example.jpa.hibernate.entity.PartTimeEmployee;


@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	//insert an employee
	public void insert(Employee employee) {
		em.persist(employee);
	}
	
//	//retrieve all employees
//	public List<Employee> retrieveAllEmployees(){
//		return em.createQuery("select e from Employee e", Employee.class).getResultList();
//	}
	
	//retrieve all PartTimeEmployee
	public List<PartTimeEmployee> retrieveAllPartTimeEmployee(){
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	//retrieve all FullTimeEmployee
	public List<FullTimeEmployee> retrieveAllFullTimeEmployee(){
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
}
