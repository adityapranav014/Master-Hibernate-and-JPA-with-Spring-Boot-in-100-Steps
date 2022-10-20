package com.example.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.hibernate.DemoApplication;
import com.example.jpa.hibernate.entity.Course;
import com.example.jpa.hibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class CriteriaQueryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	void all_courses() {
//		1. Use Criteria Builder to create a Criteria Query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
//		2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
//		3. Define Predicates etc using Criteria Builder (not required in this query)
//		4. Add Predicates etc to the Criteria Query (not required in this query)
		
//		5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query -> {}", resultList);
	}
	
	
	@Test
	void all_courses_having_100Steps() {
//		1. Use Criteria Builder to create a Criteria Query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
//		2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
//		3. Define Predicates etc using Criteria Builder
		Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");
		
//		4. Add Predicates etc to the Criteria Query 
		cq.where(like100Steps);
		
//		5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query -> {}", resultList);
	}
	
	@Test
	void all_courses_without_students() {
//		1. Use Criteria Builder to create a Criteria Query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
//		2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
//		3. Define Predicates etc using Criteria Builder
		Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
		
//		4. Add Predicates etc to the Criteria Query 
		cq.where(studentsIsEmpty);
		
//		5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query -> {}", resultList);
	}
	
	@Test
	void join() {
//		1. Use Criteria Builder to create a Criteria Query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
//		2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
//		3. Define Predicates etc using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students");
		
//		4. Add Predicates etc to the Criteria Query (not required here) 

		
//		5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query -> {}", resultList);
	}
	
	@Test
	void left_join() {
//		1. Use Criteria Builder to create a Criteria Query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
//		2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
//		3. Define Predicates etc using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
		
//		4. Add Predicates etc to the Criteria Query (not required here) 
		
		
//		5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query -> {}", resultList);
	}
}
