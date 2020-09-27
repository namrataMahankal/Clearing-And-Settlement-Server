package com.clearing.entity;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class TradeEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="tradeId")
  public int tradeId;
  @Column(name="securityId")
  public int securityId;
  @Column(name="quantity")
  public int quantity;
  @Column(name="price")
  public float price;
  @Column(name="buyerClearingMemberId")
  public int buyerClearingMemberId;
  @Column(name="sellerClearningMemberId")
  public int sellerClearningMemberId;
  @Column(name="transactionAmount")
  public float transactionAmount;
  
  
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


public int getBuyerClearingMemberId() {
	return buyerClearingMemberId;
}


public void setBuyerClearingMemberId(int buyerClearingMemberId) {
	this.buyerClearingMemberId = buyerClearingMemberId;
}


public int getSellerClearningMemberId() {
	return sellerClearningMemberId;
}


public void setSellerClearningMemberId(int sellerClearningMemberId) {
	this.sellerClearningMemberId = sellerClearningMemberId;
}


public float getTransactionAmount() {
	return transactionAmount;
}


public void setTransactionAmount(float transactionAmount) {
	this.transactionAmount = transactionAmount;
}


public static Random getRand() {
	return rand;
}


public static void setRand(Random rand) {
	TradeEntity.rand = rand;
}

  
  private static Random rand = new Random(System.currentTimeMillis());

  // Default constructor generate random Trade
  public TradeEntity(){
    // Random rand = new Random();
    this.securityId = 1 + rand.nextInt(15);
    this.quantity = 1 + rand.nextInt(10000);
    this.price = 150000*rand.nextFloat();
    this.buyerClearingMemberId = 1+ rand.nextInt(15);
    int sCMid;
    do {
      sCMid = 1 + rand.nextInt(15);
    } while (sCMid == this.buyerClearingMemberId);
    this.sellerClearningMemberId = sCMid;
    this.transactionAmount = this.quantity*this.price;    
  }


  public TradeEntity(int secId,int qty,float pc,int bCMid,int sCMid){
    this.securityId = secId;
    this.quantity = qty;
    this.price = pc;
    this.buyerClearingMemberId = bCMid;
    this.sellerClearningMemberId = sCMid;
    this.transactionAmount = qty*price;
  }
  
}