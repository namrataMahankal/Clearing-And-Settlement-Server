package com.clearing.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
//@IdClass(EquitySummaryId.class)
@Table(name = "equity_summary")
public class EquitySummaryEntity {

	@Id
	private int securityId;
	@Id
	private int clearingMemberId;
	int noOfShares;
	
	public EquitySummaryEntity(int securityId, int clearingMemberId, int noOfShares) {
		this.securityId = securityId;
		this.clearingMemberId = clearingMemberId;
		this.noOfShares = noOfShares;
	}

	public EquitySummaryEntity() {
		// TODO Auto-generated constructor stub
	}

}