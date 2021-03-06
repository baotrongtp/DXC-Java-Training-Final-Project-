package com.dxc.model;

import java.sql.Date;

public class Claim {
	private String claimNo;
	private String policyNo;
	private Date dateOccurred;
	private String reserveCurrency;
	private String reserveAmount;
	private String status;
	
	
	public Claim() {
	}
	
	public Claim(String claimNo) {
		this.claimNo = claimNo;
	}
	
	public Claim(String claimNo, String policyNo, Date dateOccurred, String reserveCurrency, String reserveAmount,
			String status) {
		this.claimNo = claimNo;
		this.policyNo = policyNo;
		this.dateOccurred = dateOccurred;
		this.reserveCurrency = reserveCurrency;
		this.reserveAmount = reserveAmount;
		this.status = status;
	}
	
	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Date getDateOccurred() {
		return dateOccurred;
	}

	public void setDateOccurred(Date dateOccurred) {
		this.dateOccurred = dateOccurred;
	}

	public String getReserveCurrency() {
		return reserveCurrency;
	}

	public void setReserveCurrency(String reserveCurrency) {
		this.reserveCurrency = reserveCurrency;
	}

	public String getReserveAmount() {
		return reserveAmount;
	}

	public void setReserveAmount(String reserveAmount) {
		this.reserveAmount = reserveAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
