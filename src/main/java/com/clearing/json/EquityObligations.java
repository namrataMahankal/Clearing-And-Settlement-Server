package com.clearing.json;

public class EquityObligations {
	
	private String securityName;
	private int openingShareBalance;
	private int securityObligation;
	
	public EquityObligations(){}
	public EquityObligations(String securityName, int openingBalance, int securityObligation){
		   this.securityName = securityName;   
		   this.openingShareBalance = openingBalance;
		   this.securityObligation = securityObligation;  
		}
	
	
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public int getOpeningShareBalance() {
		return openingShareBalance;
	}
	public void setOpeningShareBalance(int openingShareBalance) {
		this.openingShareBalance = openingShareBalance;
	}
	public int getSecurityObligation() {
		return securityObligation;
	}
	public void setSecurityObligation(int securityObligation) {
		this.securityObligation = securityObligation;
	}
	
	
	@Override
	public String toString() {
		return "EquityObligation [securityName=" + securityName + ", securityObligation=" + securityObligation + ", openingShareBalance=" + openingShareBalance+ "]";
	}
	
}
