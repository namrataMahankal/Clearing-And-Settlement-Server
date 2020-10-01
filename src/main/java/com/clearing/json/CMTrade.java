package com.clearing.json;

public class CMTrade {
	private String es;
	private int qty;
	private double price;
	private double transactionAmt;
	public CMTrade(String es, int qty, double price, double transactionAmt) {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTransactionAmt() {
		return transactionAmt;
	}
	public void setTransactionAmt(double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	
}
