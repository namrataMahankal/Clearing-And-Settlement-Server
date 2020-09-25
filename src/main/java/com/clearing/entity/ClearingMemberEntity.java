package com.clearing.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clearing_member")
public class ClearingMemberEntity {
	
	@Id
	private int clearingMemberId;
	private String clearingMemberName;
	private float clearingMemberFundBalance;
	private float amountToPay;
	
	

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

}
