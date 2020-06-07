package com.app.dto;

import java.util.Date;

public class Employee {

	private String firstname;

	private String lastname;

	private Date dateOfBirth;

	private Long id;
	
	private String gender;
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Employee(String firstname, Date dateOfBirth, String gender) {
		super();
		this.firstname = firstname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + "]";
	}

	

	
}
