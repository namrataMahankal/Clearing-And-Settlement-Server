package com.clearing.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
//@IdClass(EquitySummaryId.class)
@Table(name = "equity_summary")
public class EquitySummaryEntity implements Serializable {
    
	@Id
	private int securityId;
	
	@Id
	private int clearingMemberId;
	
	int noOfShares;
	
	int settlementChange;
	

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "clearingMemberId",insertable=false, updatable=false)
	private ClearingMemberEntity memberEntity;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="securityId",insertable=false, updatable=false)
	private SecuritiesEntity securityEntity;
	
    
	public ClearingMemberEntity getMemberEntity() {
		return memberEntity;
	}

	public void setMemberEntity(ClearingMemberEntity memberEntity) {
		this.memberEntity = memberEntity;
	}

	public int getSecurityId() {
		return securityId;
	}

	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}

	public int getClearingMemberId() {
		return clearingMemberId;
	}

	public void setClearingMemberId(int clearingMemberId) {
		this.clearingMemberId = clearingMemberId;
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
    
	public SecuritiesEntity getSecurityEntity() {
		return securityEntity;
	}


	public void setSecurityEntity(SecuritiesEntity securityEntity) {
		this.securityEntity = securityEntity;
	}
	
	public EquitySummaryEntity(int securityId, int clearingMemberId, int noOfShares, ClearingMemberEntity memberEntity, int settlementChange, SecuritiesEntity securityEntity) {
		this.securityId = securityId;
		this.clearingMemberId = clearingMemberId;
		this.noOfShares = noOfShares;
		this.memberEntity = memberEntity;
		this.settlementChange = settlementChange;
		this.securityEntity = securityEntity;
	}

	public EquitySummaryEntity() {}
}