package com.clearing.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(EquitySummaryId.class)
@Table(name = "equity_summary")
public class EquitySummary {

	@Id
	private int securityId;
	@Id
	private int clearingMemberId;
	int noOfShares;

	public EquitySummary(int securityId, int clearingMemberId, int noOfShares) {
		this.securityId = securityId;
		this.clearingMemberId = clearingMemberId;
		this.noOfShares = noOfShares;
	}

	public EquitySummary() {
		// TODO Auto-generated constructor stub
	}

	public int getSecurityId() {
		return securityId;
	}

	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}

	public int getClearingMemberId() {
		return clearingMemberId;
	}

	public void setClearingMemberId(int clearingMemberId) {
		this.clearingMemberId = clearingMemberId;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}

}
