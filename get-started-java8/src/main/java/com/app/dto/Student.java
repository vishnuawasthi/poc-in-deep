package com.app.dto;

public class Student {

	private String firstname;
	private String lastname;
	private int marks;

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

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Student(String firstname, String lastname, int marks) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.marks = marks;
	}

	
}
