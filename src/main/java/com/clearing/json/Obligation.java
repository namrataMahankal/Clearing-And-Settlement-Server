package com.clearing.json;

import java.util.Map;

public class Obligation {

	private String clearingMemberName;
	private float fundObligation;
	//private float shortage;
	//private Map<String, Integer> equityObligation;
	
	public Obligation(){}
	public Obligation(String cleringMemberName, float fund){
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
	/*public float getShortage() {
		return shortage;
	}
	public void setShortage(float shortages) {
		this.shortage = shortages;
	}*/
	/*public Map<String,Integer> getEquitiyObligation() {
		return equityObligation;
	}
	public void setEquityObligation(Map<String,Integer> equities) {
		this.equityObligation = equities;
	}*/
	
	
	@Override
	public String toString() {
		return "Obligation [clearingMemberName=" + clearingMemberName + ", fundObligation=" + fundObligation + "]";
	}
}
