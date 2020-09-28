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

	public ClearingMemberEntity(int clearingMemberId, String clearingMemberName, float clearingMemberFundBalance,
			float amountToPay) {
		this.clearingMemberId = clearingMemberId;
		this.clearingMemberName = clearingMemberName;
		this.clearingMemberFundBalance = clearingMemberFundBalance;
		this.amountToPay = amountToPay;
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
