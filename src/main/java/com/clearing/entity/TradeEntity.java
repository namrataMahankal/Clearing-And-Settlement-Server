package com.clearing.entity;

import java.util.Random;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "trade")
public class TradeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tradeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "securityId", referencedColumnName = "securityId", table = "trade")
	private SecuritiesEntity security;
	private int quantity;
	private float price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buyerClearingMemberId", referencedColumnName = "clearingMemberId")
	private ClearingMemberEntity buyerClearingMember;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sellerClearingMemberId", referencedColumnName = "clearingMemberId")
	private ClearingMemberEntity sellerClearingMember;

	private float transactionAmount;

	private static Random rand = new Random(System.currentTimeMillis());

	// Default constructor generate random Trade
	public TradeEntity() {
		// Random rand = new Random();
	}

	public TradeEntity(int tradeId, SecuritiesEntity securityId, int quantity, float price,
			ClearingMemberEntity buyerClearingMember, ClearingMemberEntity sellerClearingMember, float transactionAmount) {
		super();
		this.tradeId = tradeId;
		this.security = securityId;
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

	public SecuritiesEntity getSecurityId() {
		return security;
	}

	public void setSecurityId(SecuritiesEntity securityId) {
		this.security = securityId;
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

	public ClearingMemberEntity getBuyerClearingMember() {
		return buyerClearingMember;
	}

	public void setBuyerClearingMember(ClearingMemberEntity buyerClearingMember) {
		this.buyerClearingMember = buyerClearingMember;
	}

	public ClearingMemberEntity getSellerClearingMember() {
		return sellerClearingMember;
	}

	public void setSellerClearingMember(ClearingMemberEntity sellerClearingMember) {
		this.sellerClearingMember = sellerClearingMember;
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

	@Override
	public String toString() {
		return "TradeEntity [tradeId=" + tradeId + ", securityId=" + security.toString() + ", quantity=" + quantity
				+ ", price=" + price + ", buyerClearingMemberId=" + buyerClearingMember.toString()
				+ ", sellerClearingMemberId=" + sellerClearingMember.toString() + ", transactionAmount="
				+ transactionAmount + "]";
	}

}