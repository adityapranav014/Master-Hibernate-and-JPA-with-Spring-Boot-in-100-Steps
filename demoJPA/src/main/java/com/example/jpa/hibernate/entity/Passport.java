package com.example.jpa.hibernate.entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Passport {
	@Id
	@GeneratedValue
	private long id;
	
	private String number;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport")
	private Student student;
	
	public Passport() {}
	
	public Passport(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public long getId() {
		return id;
	}
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", passport=" + number + "]";
	}

}
