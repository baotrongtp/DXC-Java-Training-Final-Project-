package com.dxc.model;

import java.util.Date;

public class Policy {
	private String policyNo;
	private Date inceptionDate;
	private Date expiryDate;
	private String policyOwner;
	private String engineNumber;
	private String chassisNo;
	private String vehicleRegistrationNo;
	private String billingCurrency;
	private String sumInsured;
	private String rate;
	private String annualPremium;
	private String postedPremium;
	private String status;
	
	
	public Policy() {
	}

	public Policy(String policyNo, Date inceptionDate, Date expiryDate, String policyOwner, String engineNumber,
			String chassisNo, String vehicleRegistrationNo, String billingCurrency, String sumInsured, String rate,
			String annualPremium, String postedPremium, String status) {
		this.policyNo = policyNo;
		this.inceptionDate = inceptionDate;
		this.expiryDate = expiryDate;
		this.policyOwner = policyOwner;
		this.engineNumber = engineNumber;
		this.chassisNo = chassisNo;
		this.vehicleRegistrationNo = vehicleRegistrationNo;
		this.billingCurrency = billingCurrency;
		this.sumInsured = sumInsured;
		this.rate = rate;
		this.annualPremium = annualPremium;
		this.postedPremium = postedPremium;
		this.status = status;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Date getInceptionDate() {
		return inceptionDate;
	}

	public void setInceptionDate(Date inceptionDate) {
		this.inceptionDate = inceptionDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getPolicyOwner() {
		return policyOwner;
	}

	public void setPolicyOwner(String policyOwner) {
		this.policyOwner = policyOwner;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}

	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}

	public String getBillingCurrency() {
		return billingCurrency;
	}

	public void setBillingCurrency(String billingCurrency) {
		this.billingCurrency = billingCurrency;
	}

	public String getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(String sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getAnnualPremium() {
		return annualPremium;
	}

	public void setAnnualPremium(String annualPremium) {
		this.annualPremium = annualPremium;
	}

	public String getPostedPremium() {
		return postedPremium;
	}

	public void setPostedPremium(String postedPremium) {
		this.postedPremium = postedPremium;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
