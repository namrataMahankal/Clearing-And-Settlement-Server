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
	private int shortage;
	private float netPayable;

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

	public EquitySummaryEntity(EquitySummaryId id, int noOfShares, int settlementChange, int shortage, float netPayable,
			SecuritiesEntity security, ClearingMemberEntity clearingMember) {
		super();
		this.id = id;
		this.noOfShares = noOfShares;
		this.settlementChange = settlementChange;
		this.shortage = shortage;
		this.netPayable = netPayable;
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

	public int getShortage() {
		return shortage;
	}

	public void setShortage(int shortage) {
		this.shortage = shortage;
	}

	public float getNetPayable() {
		return netPayable;
	}

	public void setNetPayable(float netPayable) {
		this.netPayable = netPayable;
	}

}
