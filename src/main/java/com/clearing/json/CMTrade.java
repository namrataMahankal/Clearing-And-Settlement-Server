package com.clearing.json;

public class CMTrade {
	private String es;
	private int qty;
	private float price;
	private float transactionAmt;
	public CMTrade(String es, int qty, float price, float transactionAmt) {
		super();
		this.es = es;
		this.qty = qty;
		this.price = price;
		this.transactionAmt = transactionAmt;
	}
	public String getEs() {
		return es;
	}
	public void setEs(String es) {
		this.es = es;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTransactionAmt() {
		return transactionAmt;
	}
	public void setTransactionAmt(float transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	
}
