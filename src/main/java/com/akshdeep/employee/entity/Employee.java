package com.akshdeep.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int ID;

	@Column(name = "name")
	private String name;

	@Column(name = "email",nullable = false, unique = true)
	private String email;

	@Column(name = "age")
	private String age;

	public void setID(int Id) {
		this.ID = Id;
	}

	public int getID() {
		return ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String emailId) {
		this.email = emailId;
	}

	public String getEmail() {
		return email;
	}

	public void setAge(String ag) {
		this.age = ag;
	}

	public String getAge() {
		return age;
	}
}
