package com.clearing.json;

public class Trade {
	private String eS;
	private int qty;
	private double price;
	private String buyerCM;
	private String sellerCM;
	private double transactionAmt;

	public Trade() {
	}

	public Trade(String eS, int qty, double price, String buyerCM, String sellerCM, double transactionAmt) {
		super();
		this.eS = eS;
		this.qty = qty;
		this.price = price;
		this.buyerCM = buyerCM;
		this.sellerCM = sellerCM;
		this.transactionAmt = transactionAmt;
	}

	public String geteS() {
		return eS;
	}

	public void seteS(String eS) {
		this.eS = eS;
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

	public String getBuyerCM() {
		return buyerCM;
	}

	public void setBuyerCM(String buyerCM) {
		this.buyerCM = buyerCM;
	}

	public String getSellerCM() {
		return sellerCM;
	}

	public void setSellerCM(String sellerCM) {
		this.sellerCM = sellerCM;
	}

	public double getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	@Override
	public String toString() {
		return "Trade [eS=" + eS + ", qty=" + qty + ", price=" + price + ", buyerCM=" + buyerCM + ", sellerCM="
				+ sellerCM + ", transactionAmt=" + transactionAmt + "]";
	}

	
}