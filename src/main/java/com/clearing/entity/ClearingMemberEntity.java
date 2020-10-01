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
@Table(name = "clearing_member")
public class ClearingMemberEntity {
	
	@Id
	private int clearingMemberId;
	private double amountToPay;
	private double clearingMemberFundBalance;
	private String clearingMemberName;
	private double interestRate;
	private double shortage;
	private double netPayable;
	private double corporateActionChange;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, mappedBy = "clearingMember")
	@Column(insertable=false, updatable=false)
	private Set<EquitySummaryEntity> equityEntity;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, mappedBy = "clearingMember")
	@Column(insertable=false, updatable=false)
    private Set<CorporateActionSummaryEntity> corporateSummaryEntity;

	
	public ClearingMemberEntity(int clearingMemberId, String clearingMemberName, double clearingMemberFundBalance,
			double amountToPay,Set<EquitySummaryEntity> equityEntity,Set<CorporateActionSummaryEntity> corporateSummaryEntity, double interestRate, double shortage, double netPayable) {
		this.clearingMemberId = clearingMemberId;
		this.clearingMemberName = clearingMemberName;
		this.clearingMemberFundBalance = clearingMemberFundBalance;
		this.amountToPay = amountToPay;
		this.equityEntity = equityEntity;
		this.corporateSummaryEntity = corporateSummaryEntity;
		this.interestRate = interestRate;
		this.shortage = shortage;
		this.netPayable = netPayable;

	}

	public ClearingMemberEntity() {}
	
	
	public Set<EquitySummaryEntity> getEquityEntity() {
		return equityEntity;
	}

	public void setEquityEntity(Set<EquitySummaryEntity> equityEntity) {
		this.equityEntity = equityEntity;
	}

	public int getClearingMemberId() {
		return clearingMemberId;
	}



	public void setClearingMemberId(int clearingMemberId) {
		this.clearingMemberId = clearingMemberId;
	}



	public String getClearingMemberName() {
		return clearingMemberName;
	}



	public void setClearingMemberName(String clearingMemberName) {
		this.clearingMemberName = clearingMemberName;
	}



	public double getClearingMemberFundBalance() {
		return clearingMemberFundBalance;
	}



	public void setClearingMemberFundBalance(double clearingMemberFundBalance) {
		this.clearingMemberFundBalance = clearingMemberFundBalance;
	}



	public double getAmountToPay() {
		return amountToPay;
	}



	public void setAmountToPay(double amountToPay) {
		this.amountToPay = amountToPay;
	}
	
	public double getShortage() {
		return shortage;
	}

	public void setShortage(double shortage) {
		this.shortage = shortage;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getNetPayable() {
		return netPayable;
	}

	public void setNetPayable(double netPayable) {
		this.netPayable = netPayable;
	}

	public double getCorporateActionChange() {
		return corporateActionChange;
	}

	public void setCorporateActionChange(double corporateActionChange) {
		this.corporateActionChange = corporateActionChange;
	}

}