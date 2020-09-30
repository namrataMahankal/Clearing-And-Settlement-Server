package com.clearing.json;



public class Obligation {

	private String clearingMemberName;
	private float fundObligation;
	//private float shortage;
	//private Map<String, Integer> equityObligation;
	
	public Obligation(){}
	
	public Obligation(String clearingMemberName, float fund){
		   this.clearingMemberName = clearingMemberName;
		   this.fundObligation = fund;
		   
	}
	
	public String getClearingMemberame() {
		return clearingMemberName;
	}
	public void setClearingMemberName(String name) {
		this.clearingMemberName = name;
	}
	public float getFundObligation() {
		return fundObligation;
	}
	public void setFundObligaton(float fund) {
		this.fundObligation = fund;
	}
		

	@Override
	public String toString() {
		return "Obligation [clearingMemberName=" + clearingMemberName + ", fundObligation=" + fundObligation + "]";
	}
}
