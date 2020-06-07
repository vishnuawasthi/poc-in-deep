package com.app.dto;

import java.util.Date;
import java.util.List;

public class AccountDetail {

	
	private Date startDate;
	
	private Date cancelDate;
	
	private String accountType;
	
	private String clientCode;
	
	private List<EligibilityDetail> eligibilities;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public List<EligibilityDetail> getEligibilities() {
		return eligibilities;
	}

	public void setEligibilities(List<EligibilityDetail> eligibilities) {
		this.eligibilities = eligibilities;
	}
	
	
	
}
