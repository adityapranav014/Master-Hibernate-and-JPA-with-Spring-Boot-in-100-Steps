package com.example.jpa.hibernate.entity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Review {
	@Id
	@GeneratedValue
	private long id;
	
	@Enumerated(EnumType.STRING)
	private ReviewRating rating;
	
	private String description;
	
	@ManyToOne
	private Course course;
	
	
	public Review() {}
	
	public Review(ReviewRating rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public ReviewRating getRating() {
		return rating;
	}

	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + "]";
	}

	

}
