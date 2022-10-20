package com.example.jpa.hibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries(value = {
		@NamedQuery(name="query_get_all_courses", query="Select c From Course c"),
		@NamedQuery(name="query_get_100_step_courses", query="Select c From Course c where name like '%100 Steps'"),
		@NamedQuery(name="query_get_all_courses_join_fetch", query="Select c From Course c JOIN FETCH c.students s"),
		
})

@SQLDelete(sql="update course set is_deleted=true where id=?")
@Where(clause="is_deleted = false")
public class Course {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	@JsonIgnore
	private List<Student> students = new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	private boolean isDeleted; 
	
	public Course() {}
	
	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
