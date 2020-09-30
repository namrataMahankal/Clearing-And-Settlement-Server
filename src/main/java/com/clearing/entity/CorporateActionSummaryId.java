package com.clearing.entity;

import java.io.Serializable;
import java.util.Objects;




public class CorporateActionSummaryId implements Serializable {
	

	private int clearingMemberId;

	private int securityId;
	
	
	public CorporateActionSummaryId(int clearingMemberId, int securityId) {
		this.clearingMemberId = clearingMemberId;
		this.securityId = securityId;
	}


	public int getClearingMemberId() {
		return clearingMemberId;
	}


	public void setClearingMemberId(int clearingMemberId) {
		this.clearingMemberId = clearingMemberId;
	}


	public int getSecurityId() {
		return securityId;
	}


	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}

	public CorporateActionSummaryId() {
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CorporateActionSummaryId corpSummaryId = (CorporateActionSummaryId) o;
		return securityId == corpSummaryId.securityId && clearingMemberId == corpSummaryId.clearingMemberId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(securityId, clearingMemberId);
	}

}