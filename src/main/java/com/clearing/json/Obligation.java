package com.clearing.json;



public class Obligation {

	private String clearingMemberName;
	private double fundObligation;

	
	public Obligation(){}
	
	public Obligation(String clearingMemberName, double fund){
		   this.clearingMemberName = clearingMemberName;
		   this.fundObligation = fund;
		   
	}
	
	public String getClearingMemberame() {
		return clearingMemberName;
	}
	public void setClearingMemberName(String name) {
		this.clearingMemberName = name;
	}
	public double getFundObligation() {
		return fundObligation;
	}
	public void setFundObligaton(double fund) {
		this.fundObligation = fund;
	}
		

	@Override
	public String toString() {
		return "Obligation [clearingMemberName=" + clearingMemberName + ", fundObligation=" + fundObligation + "]";
	}
}
