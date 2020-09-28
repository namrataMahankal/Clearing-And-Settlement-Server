package com.clearing.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "securities")
public class SecuritiesEntity {

	@Id
	private int securityId;
	private float interestRate;
	private float marketPrice;
	private String securityName;

	public SecuritiesEntity(int securityId, String securityName, float marketPrice, float interestRate) {
		this.securityId = securityId;
		this.securityName = securityName;
		this.marketPrice = marketPrice;
		this.interestRate = interestRate;
	}

	public SecuritiesEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getSecurityId() {
		return securityId;
	}

	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public float getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	@Override
	public String toString() {
		return "SecuritiesEntity [securityId=" + securityId + ", interestRate=" + interestRate + ", marketPrice="
				+ marketPrice + ", securityName=" + securityName + "]";
	}

}