package com.app.dto;

import java.util.List;

import org.springframework.util.StringUtils;

public class MasterData {

	List<Employee> employees;

	
	
	List<Employee> permanentEmployee;

	List<Employee> constractEmployee;;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getPermanentEmployee() {
		return permanentEmployee;
	}

	public void setPermanentEmployee(List<Employee> permanentEmployee) {
		this.permanentEmployee = permanentEmployee;
	}

	public List<Employee> getConstractEmployee() {
		return constractEmployee;
	}

	public void setConstractEmployee(List<Employee> constractEmployee) {
		this.constractEmployee = constractEmployee;
	}

}
