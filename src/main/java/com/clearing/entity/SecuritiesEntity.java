package com.clearing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security")
public class SecuritiesEntity {
	
	@Id
	@GeneratedValue
	@Column(name="securityId")
	private int securityId;
	@Column(name="securityName")
	private String securityName;
	@Column(name="marketPrice")
	private float marketPrice;
	@Column(name="interestRate")
	private float interestRate;	
	
	public int getSecurityId() {
		return securityId;
	}


	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}


	public String getSecurityName() {
		return securityName;
	}


	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}


	public float getMarketPrice() {
		return marketPrice;
	}


	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
	}


	public float getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	

	public SecuritiesEntity(int securityId, String securityName, float marketPrice, float interestRate) {
		this.securityId = securityId;
		this.securityName = securityName;
		this.marketPrice = marketPrice;
		this.interestRate = interestRate;
	}


	public SecuritiesEntity() {
		// TODO Auto-generated constructor stub
	}

}