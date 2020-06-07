package com.app.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MemberDetail {

	private String firstName;

	private String lastName;

	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;

	private String deptCode;

	private Integer numberOfChilds;

	private String stateCode;

	private String countryCode;

	private List<String> executedRules;// = new ArrayList<String>();

	private boolean isQualified = true;

	private String disQualifiedReason;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public Integer getNumberOfChilds() {
		return numberOfChilds;
	}

	public void setNumberOfChilds(Integer numberOfChilds) {
		this.numberOfChilds = numberOfChilds;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<String> getExecutedRules() {
		if (CollectionUtils.isEmpty(executedRules)) {
			executedRules = new ArrayList<String>();
		}
		return executedRules;
	}

	public void setExecutedRules(List<String> executedRules) {
		this.executedRules = executedRules;
	}

	public boolean isQualified() {
		return isQualified;
	}

	public void setQualified(boolean isQualified) {
		this.isQualified = isQualified;
	}

	public String getDisQualifiedReason() {
		return disQualifiedReason;
	}

	public void setDisQualifiedReason(String disQualifiedReason) {
		this.disQualifiedReason = disQualifiedReason;
	}

	@Override
	public String toString() {
		return "MemberDetail [executedRules=" + executedRules + "]";
	}

}
