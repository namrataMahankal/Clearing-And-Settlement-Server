package com.clearing.json;

public class Trade {
	private String ES;
	private int Qty;
	private float Price;
	private String BuyerCM;
	private String SellerCM;
	private float TransactionAmt;

	public Trade() {
	}

	public Trade(String eS, int qty, float price, String buyerCM, String sellerCM, float transactionAmt) {
		super();
		ES = eS;
		Qty = qty;
		Price = price;
		BuyerCM = buyerCM;
		SellerCM = sellerCM;
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

	public String getBuyerCM() {
		return BuyerCM;
	}

	public void setBuyerCM(String buyerCM) {
		BuyerCM = buyerCM;
	}

	public String getSellerCM() {
		return SellerCM;
	}

	public void setSellerCM(String sellerCM) {
		SellerCM = sellerCM;
	}

	public float getTransactionAmt() {
		return TransactionAmt;
	}

	public void setTransactionAmt(float transactionAmt) {
		TransactionAmt = transactionAmt;
	}

}