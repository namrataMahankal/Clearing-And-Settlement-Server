package com.clearing.entity;

public class CorporateActionSummary {
	
	
	private int clearingMemberId;
	private int securityId;
	private int initialShareBalance;
	private int finalShareBalance;
	private String action;
	private String parameter;
	
	
	public CorporateActionSummary(int clearingMemberId, int securityId, int initialShareBalance, int finalShareBalance,
			String action, String parameter) {
		this.clearingMemberId = clearingMemberId;
		this.securityId = securityId;
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


	public int getSecurityId() {
		return securityId;
	}


	public void setSecurityId(int securityId) {
		this.securityId = securityId;
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


	public CorporateActionSummary() {
	}

}
