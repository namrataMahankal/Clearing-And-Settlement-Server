package com.clearing.json;

public class CostOfSettlementShares {

	private String securities;
	private int shares;
	private double pricePerShare;
	private double cost;

	public CostOfSettlementShares(String securities, int shares, double pricePerShare, double cost) {
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

	public double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
