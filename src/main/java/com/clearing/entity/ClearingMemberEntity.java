package com.clearing.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clearing_member")
public class ClearingMemberEntity {
	
	@Id
	private int clearingMemberId;
	private float amountToPay;
	private float clearingMemberFundBalance;
	private String clearingMemberName;
	private float interestRate;
	private float shortage;
	private float netPayable;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, mappedBy = "clearingMember")
    private Set<EquitySummaryEntity> equityEntity;
	
	
	public ClearingMemberEntity(int clearingMemberId, String clearingMemberName, float clearingMemberFundBalance,
			float amountToPay,Set<EquitySummaryEntity> equityEntity, float interestRate, float shortage, float netPayable) {
		this.clearingMemberId = clearingMemberId;
		this.clearingMemberName = clearingMemberName;
		this.clearingMemberFundBalance = clearingMemberFundBalance;
		this.amountToPay = amountToPay;
		this.equityEntity = equityEntity;
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



	public float getClearingMemberFundBalance() {
		return clearingMemberFundBalance;
	}



	public void setClearingMemberFundBalance(float clearingMemberFundBalance) {
		this.clearingMemberFundBalance = clearingMemberFundBalance;
	}



	public float getAmountToPay() {
		return amountToPay;
	}



	public void setAmountToPay(float amountToPay) {
		this.amountToPay = amountToPay;
	}
	
	public float getShortage() {
		return shortage;
	}

	public void setShortage(float shortage) {
		this.shortage = shortage;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public float getNetPayable() {
		return netPayable;
	}

	public void setNetPayable(float netPayable) {
		this.netPayable = netPayable;
	}

	
}