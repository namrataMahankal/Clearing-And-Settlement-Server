package com.clearing.json;

public class Trade {
	private String eS;
	private int qty;
	private float price;
	private String buyerCM;
	private String sellerCM;
	private float transactionAmt;

	public Trade() {
	}

	public Trade(String eS, int qty, float price, String buyerCM, String sellerCM, float transactionAmt) {
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
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

	public float getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(float transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	@Override
	public String toString() {
		return "Trade [eS=" + eS + ", qty=" + qty + ", price=" + price + ", buyerCM=" + buyerCM + ", sellerCM="
				+ sellerCM + ", transactionAmt=" + transactionAmt + "]";
	}

	
}