package com.clearing.json;

public class CMTrade {
	private String ES;
	private int Qty;
	private float Price;
	private float TransactionAmt;

	public CMTrade(String eS, int qty, float price, float transactionAmt) {
		super();
		ES = eS;
		Qty = qty;
		Price = price;
		TransactionAmt = transactionAmt;
	}

	public String getES() {
		return ES;
	}

	public void setES(String eS) {
		ES = eS;
	}

	public int getQty() {
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public float getTransactionAmt() {
		return TransactionAmt;
	}

	public void setTransactionAmt(float transactionAmt) {
		TransactionAmt = transactionAmt;
	}

}
