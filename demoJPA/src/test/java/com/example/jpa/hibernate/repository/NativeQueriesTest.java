package com.example.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.hibernate.DemoApplication;
import com.example.jpa.hibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	void native_queries_basic() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM COURSE -> {}", resultList);
	}
	
	@Test
	void native_queries_with_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE where id = ?", Course.class);
		query.setParameter(1, 10001L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM COURSE where id = ? -> {}", resultList);
	}
	
	@Test
	void native_queries_with_named_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE where id = :id", Course.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM COURSE where id = :id -> {}", resultList);
	}
	
	@Test
	@Transactional
	void native_queries_to_update() {
		Query query = em.createNativeQuery("Update COURSE set last_updated_date=sysdate()");
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("No Of Rows Updated -> {}", noOfRowsUpdated);
	}
}
