package com.clearing.json;

public class CostOfSettlementShares {

	private String securities;
	private int shares;
	private float pricePerShare;
	private float cost;

	public CostOfSettlementShares(String securities, int shares, float pricePerShare, float cost) {
		super();
		this.securities = securities;
		this.shares = shares;
		this.pricePerShare = pricePerShare;
		this.cost = cost;
	}

	public String getSecurities() {
		return securities;
	}

	public void setSecurities(String securities) {
		this.securities = securities;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public float getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(float pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

}
