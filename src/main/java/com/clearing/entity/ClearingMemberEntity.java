package com.clearing.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
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

	public ClearingMemberEntity(int clearingMemberId, float amountToPay, float clearingMemberFundBalance,
			String clearingMemberName, float interestRate, float shortage, float netPayable) {
		super();
		this.clearingMemberId = clearingMemberId;
		this.amountToPay = amountToPay;
		this.clearingMemberFundBalance = clearingMemberFundBalance;
		this.clearingMemberName = clearingMemberName;
		this.interestRate = interestRate;
		this.shortage = shortage;
		this.netPayable = netPayable;
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

	public ClearingMemberEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getClearingMemberId() {
		return clearingMemberId;
	}

	public void setClearingMemberId(int clearingMemberId) {
		this.clearingMemberId = clearingMemberId;
	}

	public float getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(float amountToPay) {
		this.amountToPay = amountToPay;
	}

	public float getClearingMemberFundBalance() {
		return clearingMemberFundBalance;
	}

	public void setClearingMemberFundBalance(float clearingMemberFundBalance) {
		this.clearingMemberFundBalance = clearingMemberFundBalance;
	}

	public String getClearingMemberName() {
		return clearingMemberName;
	}

	public void setClearingMemberName(String clearingMemberName) {
		this.clearingMemberName = clearingMemberName;
	}

	@Override
	public String toString() {
		return "ClearingMember [clearingMemberId=" + clearingMemberId + ", amountToPay=" + amountToPay
				+ ", clearingMemberFundBalance=" + clearingMemberFundBalance + ", clearingMemberName="
				+ clearingMemberName + "]";
	}

}
