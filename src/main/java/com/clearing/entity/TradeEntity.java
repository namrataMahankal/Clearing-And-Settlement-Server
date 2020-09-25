package com.clearing.entity;

import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "trade")
public class TradeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tradeId;
	
	@ManyToOne(targetEntity = SecuritiesEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "securityId", referencedColumnName = "securityId")
	private int securityId;
	private int quantity;
	private float price;

	@ManyToOne(targetEntity = ClearingMember.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "buyerClearingMemberId", referencedColumnName = "clearingMemberId")
	private int buyerClearingMemberId;

	@ManyToOne(targetEntity = ClearingMember.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "sellerClearingMemberId", referencedColumnName = "clearingMemberId")
	private int sellerClearingMemberId;

	private float transactionAmount;

	private String sellerClearingMember;

	private static Random rand = new Random(System.currentTimeMillis());

	// Default constructor generate random Trade
	public TradeEntity() {
		// Random rand = new Random();
	}

	public TradeEntity(int tradeId, int securityId, int quantity, float price, int buyerClearingMemberId,
			int sellerClearingMemberId, float transactionAmount) {
		super();
		this.tradeId = tradeId;
		this.securityId = securityId;
		this.quantity = quantity;
		this.price = price;
		this.buyerClearingMemberId = buyerClearingMemberId;
		this.sellerClearingMemberId = sellerClearingMemberId;
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

	public int getBuyerClearingMemberId() {
		return buyerClearingMemberId;
	}

	public void setBuyerClearingMemberId(int buyerClearingMemberId) {
		this.buyerClearingMemberId = buyerClearingMemberId;
	}

	public int getSellerClearingMemberId() {
		return sellerClearingMemberId;
	}

	public void setSellerClearingMemberId(int sellerClearingMemberId) {
		this.sellerClearingMemberId = sellerClearingMemberId;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

}