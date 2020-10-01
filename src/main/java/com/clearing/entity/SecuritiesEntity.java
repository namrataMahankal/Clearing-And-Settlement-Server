package com.clearing.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "securities")
public class SecuritiesEntity {

	@Id
	private int securityId;
	private int interestRate;
	private double marketPrice;
	private String securityName;

	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, mappedBy = "clearingMember")
	@Column(insertable=false, updatable=false)
    private Set<EquitySummaryEntity> equityEntity;
	
	
	public SecuritiesEntity(int securityId, String securityName, double marketPrice, int interestRate, Set<EquitySummaryEntity> equityEntity) {
		this.securityId = securityId;
		this.securityName = securityName;
		this.marketPrice = marketPrice;
		this.interestRate = interestRate;
		this.equityEntity = equityEntity;
	}

	public SecuritiesEntity() {

	}

	public int getSecurityId() {
		return securityId;
	}

	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	
	public Set<EquitySummaryEntity> getEquityEntity() {
		return equityEntity;
	}

	public void setEquityEntity(Set<EquitySummaryEntity> equityEntity) {
		this.equityEntity = equityEntity;
	}


	@Override
	public String toString() {
		return "SecuritiesEntity [securityId=" + securityId + ", interestRate=" + interestRate + ", marketPrice="
				+ marketPrice + ", securityName=" + securityName + "]";
	}

}