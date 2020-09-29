package com.clearing.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EquitySummaryId implements Serializable {

	@Column(name = "securityId")
    private int securityId;
    @Column(name = "clearingMemberId")
    private int clearingMemberId;

	public EquitySummaryId() {
		// TODO Auto-generated constructor stub
	}

	public EquitySummaryId(int securityId, int clearingMemberId) {
		this.securityId = securityId;
		this.clearingMemberId = clearingMemberId;
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

	
}
