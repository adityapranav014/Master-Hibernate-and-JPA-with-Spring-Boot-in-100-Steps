package com.example.jpa.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
//@Entity
//@Inheritance(strategy=InheritanceType.JOINED) 
//@DiscriminatorColumn(name = "EmployeeType")
public abstract class Employee {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	
	public Employee() {}
	
	public Employee(String name) {
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
