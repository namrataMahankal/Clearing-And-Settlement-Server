package com.clearing.json;

public class CostOfSettlementFund {

	private float fundsToBeBorrowed;
	private float borrowingRate;
	private float costIncurred;

	public CostOfSettlementFund(float fundsToBeBorrowed, float borrowingRate, float costIncurred) {
		super();
		this.fundsToBeBorrowed = fundsToBeBorrowed;
		this.borrowingRate = borrowingRate;
		this.costIncurred = costIncurred;
	}

	public float getFundsToBeBorrowed() {
		return fundsToBeBorrowed;
	}

	public void setFundsToBeBorrowed(float fundsToBeBorrowed) {
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
