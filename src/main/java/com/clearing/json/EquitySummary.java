package com.clearing.json;

public class EquitySummary {

	private String ES;
	private int SharesBalance;

	public EquitySummary() {
		super();
	}

	public EquitySummary(String eS, int sharesBalance) {
		super();
		ES = eS;
		SharesBalance = sharesBalance;
	}

	public String getES() {
		return ES;
	}

	public void setES(String eS) {
		ES = eS;
	}

	public int getSharesBalance() {
		return SharesBalance;
	}

	public void setSharesBalance(int sharesBalance) {
		SharesBalance = sharesBalance;
	}

}
