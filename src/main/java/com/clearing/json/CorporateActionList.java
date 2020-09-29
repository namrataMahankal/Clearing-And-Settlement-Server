package com.clearing.json;

import java.util.Map;

public class CorporateActionList {
	
	private String securityName;
	private int initialShareBalance;
	private int finalShareBalance;
	private String action;
	private String parameter;
	
	
	public CorporateActionList(String securityName, int initialShareBalance, int finalShareBalance,
			String action, String parameter) {
		this.securityName = securityName;
		this.initialShareBalance = initialShareBalance;
		this.finalShareBalance = finalShareBalance;
		this.action = action;
		this.parameter = parameter;
	}
	
	
	public String getSecurityName() {
		return securityName;
	}




	public void setSecurityName(String securityName) {
		this.securityName = securityName;
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

	public CorporateActionList() {
	}

}