package com.clearing.json;

public class CostOfSettlementFund {

	private int fundsToBeBorrowed;
	private float borrowingRate;
	private float costIncurred;

	public CostOfSettlementFund(float totalCost, int fundsToBeBorrowed, float borrowingRate, float costIncurred) {
		super();
		this.fundsToBeBorrowed = fundsToBeBorrowed;
		this.borrowingRate = borrowingRate;
		this.costIncurred = costIncurred;
	}

	public int getFundsToBeBorrowed() {
		return fundsToBeBorrowed;
	}

	public void setFundsToBeBorrowed(int fundsToBeBorrowed) {
		this.fundsToBeBorrowed = fundsToBeBorrowed;
	}

	public float getBorrowingRate() {
		return borrowingRate;
	}

	public void setBorrowingRate(float borrowingRate) {
		this.borrowingRate = borrowingRate;
	}

	public float getCostIncurred() {
		return costIncurred;
	}

	public void setCostIncurred(float costIncurred) {
		this.costIncurred = costIncurred;
	}

}
