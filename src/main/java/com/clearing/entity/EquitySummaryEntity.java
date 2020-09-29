package com.clearing.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "equity_summary")
public class EquitySummaryEntity {
	@EmbeddedId
	private EquitySummaryId id;
	private int noOfShares;
	private int settlementChange;
	
	@MapsId("securityId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "securityId", referencedColumnName = "securityId")
	private SecuritiesEntity security;
	
	@MapsId("clearingMemberId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clearingMemberId", referencedColumnName = "clearingMemberId")
	private ClearingMemberEntity clearingMember;

	public EquitySummaryEntity() {
		super();
	}

	public EquitySummaryEntity(EquitySummaryId id, int noOfShares, int settlementChange, SecuritiesEntity security,
			ClearingMemberEntity clearingMember) {
		super();
		this.id = id;
		this.noOfShares = noOfShares;
		this.settlementChange = settlementChange;
		this.security = security;
		this.clearingMember = clearingMember;
	}

	public EquitySummaryId getId() {
		return id;
	}

	public void setId(EquitySummaryId id) {
		this.id = id;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}

	public int getSettlementChange() {
		return settlementChange;
	}

	public void setSettlementChange(int settlementChange) {
		this.settlementChange = settlementChange;
	}

	public SecuritiesEntity getSecurity() {
		return security;
	}

	public void setSecurity(SecuritiesEntity security) {
		this.security = security;
	}

	public ClearingMemberEntity getClearingMember() {
		return clearingMember;
	}

	public void setClearingMember(ClearingMemberEntity clearingMember) {
		this.clearingMember = clearingMember;
	}


}
