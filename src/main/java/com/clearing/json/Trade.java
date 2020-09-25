package com.clearing.json;

public class Trade {
	private int tradeId;
	private int securityId;
	private int quantity;
	private float price;
	private String buyerClearingMember;
	private String sellerClearingMember;
	private float transactionAmount;

	public Trade() {
	}

	public Trade(int tradeId, int securityId, int quantity, float price, String buyerClearingMember,
			String sellerClearingMember, float transactionAmount) {
		super();
		this.tradeId = tradeId;
		this.securityId = securityId;
		this.quantity = quantity;
		this.price = price;
		this.buyerClearingMember = buyerClearingMember;
		this.sellerClearingMember = sellerClearingMember;
		this.transactionAmount = transactionAmount;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public int getSecurityId() {
		return securityId;
	}

	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getBuyerClearingMember() {
		return buyerClearingMember;
	}

	public void setBuyerClearingMember(String buyerClearingMember) {
		this.buyerClearingMember = buyerClearingMember;
	}

	public String getSellerClearingMember() {
		return sellerClearingMember;
	}

	public void setSellerClearingMember(String sellerClearingMember) {
		this.sellerClearingMember = sellerClearingMember;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

}
