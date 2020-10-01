package com.clearing.json;

public class CostOfSettlementFund {

	private double fundsToBeBorrowed;
	private double borrowingRate;
	private double costIncurred;

	public CostOfSettlementFund(double fundsToBeBorrowed, double borrowingRate, double costIncurred) {
		super();
		this.fundsToBeBorrowed = fundsToBeBorrowed;
		this.borrowingRate = borrowingRate;
		this.costIncurred = costIncurred;
	}

	public double getFundsToBeBorrowed() {
		return fundsToBeBorrowed;
	}

	public void setFundsToBeBorrowed(double fundsToBeBorrowed) {
		this.fundsToBeBorrowed = fundsToBeBorrowed;
	}

	public double getBorrowingRate() {
		return borrowingRate;
	}

	public void setBorrowingRate(double borrowingRate) {
		this.borrowingRate = borrowingRate;
	}

	public double getCostIncurred() {
		return costIncurred;
	}

	public void setCostIncurred(double costIncurred) {
		this.costIncurred = costIncurred;
	}

}
