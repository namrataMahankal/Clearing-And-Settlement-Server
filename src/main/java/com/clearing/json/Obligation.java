package com.clearing.json;

import java.util.Map;

public class Obligation {

	private long CMID;
	private float fundObligation;
	//private float shortage;
	private Map<Integer, Integer> equityObligation;
	
	public Obligation(){}
	public Obligation(long cmid, float fund, Map<Integer,Integer>equities){
		   this.CMID = cmid;
		   this.fundObligation = fund;
		   this.equityObligation = equities;
		}
	
	public long getCMId() {
		return CMID;
	}
	public void setCMId(long cmid) {
		this.CMID = cmid;
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
	public Map<Integer,Integer> getEquitiyObligation() {
		return equityObligation;
	}
	public void setEquityObligation(Map<Integer,Integer> equities) {
		this.equityObligation = equities;
	}
	
	
	@Override
	public String toString() {
		return "Obligation [CMID=" + CMID + ", fundObligation=" + fundObligation +", equityObligation" + equityObligation+ "]";
	}
}
