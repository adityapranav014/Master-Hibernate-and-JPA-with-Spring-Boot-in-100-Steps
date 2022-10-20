package com.example.jpa.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.jpa.hibernate.entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> { 
	
	List<Course> findByNameAndId(String name, Long id);
	List<Course> findByName(String name);
	List<Course> countByName(String name);
	List<Course> findByNameOrderByIdDesc(String name);
	List<Course> deleteByName(String name);
	
	//JPQL
	@Query("Select c From Course c where name like '%100 Steps'")
	List<Course> courseWith100StepsInName();
	
	//Native Query
	@Query(value = "Select * From Course c where name like '%100 Steps'", nativeQuery=true)
	List<Course> courseWith100StepsInNameUsingNativeQuery();
	
	//Named Query
	@Query(name = "query_get_100_step_courses")
	List<Course> courseWith100StepsInNameUsingNamedQuery()  ;
}
 