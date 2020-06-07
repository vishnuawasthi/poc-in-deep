package com.app.dto;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {

	private String name;

	private String deptId;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfbirth;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date activationDate;

	private float grossSalary;

	private Float perDaySalary;

	private Float workingDays;

	private String jobType;

	private String isActive = "Y";

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Date getDateOfbirth() {
		
		
		
		return dateOfbirth;
	}

	public void setDateOfbirth(Date dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public float getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}

	public Float getPerDaySalary() {
		return perDaySalary;
	}

	public void setPerDaySalary(Float perDaySalary) {
		this.perDaySalary = perDaySalary;
	}

	public Float getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(Float workingDays) {
		this.workingDays = workingDays;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", deptId=" + deptId + ", dateOfbirth=" + dateOfbirth + ", activationDate="
				+ activationDate + ", grossSalary=" + grossSalary + ", perDaySalary=" + perDaySalary + ", workingDays="
				+ workingDays + ", jobType=" + jobType + ", isActive=" + isActive + "]";
	}
	
	

}
