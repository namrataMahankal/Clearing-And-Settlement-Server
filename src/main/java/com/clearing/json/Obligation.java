package com.clearing.json;

import java.util.Map;

public class Obligation {

	private String CMName;
	private float fundObligation;
	//private float shortage;
	private Map<String, Integer> equityObligation;
	
	public Obligation(){}
	public Obligation(String cmName, float fund, Map<String,Integer>equities){
		   this.CMName = cmName;
		   this.fundObligation = fund;
		   this.equityObligation = equities;
		}
	
	public String getCMName() {
		return CMName;
	}
	public void setCMName(String cmName) {
		this.CMName = cmName;
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
	public Map<String,Integer> getEquitiyObligation() {
		return equityObligation;
	}
	public void setEquityObligation(Map<String,Integer> equities) {
		this.equityObligation = equities;
	}
	
	
	@Override
	public String toString() {
		return "Obligation [CMName=" + CMName + ", fundObligation=" + fundObligation +", equityObligation" + equityObligation+ "]";
	}
}
