package com.app.dto;

public class EmpDemp {

	private Long id;

	private String name;
	private Float salary;

	private String deptCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public EmpDemp(Long id, String name, Float salary, String deptCode) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.deptCode = deptCode;
	}

	@Override
	public String toString() {
		return "EmpDemp [id=" + id + ", name=" + name + ", salary=" + salary + ", deptCode=" + deptCode + "]";
	}

}
