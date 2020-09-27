package com.clearing.json;

import java.util.Map;

public class Balance {
    
	private long CMID;
	private float fundBalance;
	private Map<String, Integer> equityBalance;
	
	public Balance(){}
	public Balance(long cmid, float fund, Map<String,Integer>equities){
		   this.CMID = cmid;
		   this.fundBalance = fund;
		   this.equityBalance = equities;
		}
	
	public long getCMId() {
		return CMID;
	}
	public void setCMId(long cmid) {
		this.CMID = cmid;
	}
	public float getFundBalance() {
		return fundBalance;
	}
	public void setFundBalance(float fund) {
		this.fundBalance = fund;
	}
	public Map<String,Integer> getEquitiyBalance() {
		return equityBalance;
	}
	public void setEquityBalance(Map<String,Integer> equities) {
		this.equityBalance = equities;
	}
	
	
	@Override
	public String toString() {
		return "Balance [CMID=" + CMID + ", fundBalance=" + fundBalance + ", equityBalance" + equityBalance+ "]";
	}
	
}
