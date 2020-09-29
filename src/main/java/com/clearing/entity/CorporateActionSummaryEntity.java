package com.clearing.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "corporate_action_summary")
public class CorporateActionSummaryEntity {
	@Id
	private int clearingMemberId;
	
	@ManyToOne
	@JoinColumn(name = "securityId", referencedColumnName = "securityId")
	private SecuritiesEntity security;
	
	private int initialShareBalance;
	private int finalShareBalance;
	private String action;
	private String parameter;
	
	public CorporateActionSummaryEntity(int clearingMemberId, SecuritiesEntity security, int initialShareBalance, int finalShareBalance,
			String action, String parameter) {
		this.clearingMemberId = clearingMemberId;
		this.security = security;
		this.initialShareBalance = initialShareBalance;
		this.finalShareBalance = finalShareBalance;
		this.action = action;
		this.parameter = parameter;
	}


	public int getClearingMemberId() {
		return clearingMemberId;
	}


	public void setClearingMemberId(int clearingMemberId) {
		this.clearingMemberId = clearingMemberId;
	}


	public SecuritiesEntity getSecurity() {
		return security;
	}


	public void setSecurity(SecuritiesEntity security) {
		this.security = security;
	}


	public int getInitialShareBalance() {
		return initialShareBalance;
	}


	public void setInitialShareBalance(int initialShareBalance) {
		this.initialShareBalance = initialShareBalance;
	}


	public int getFinalShareBalance() {
		return finalShareBalance;
	}


	public void setFinalShareBalance(int finalShareBalance) {
		this.finalShareBalance = finalShareBalance;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getParameter() {
		return parameter;
	}


	public void setParameter(String parameter) {
		this.parameter = parameter;
	}


	public CorporateActionSummaryEntity() {
	}

}
