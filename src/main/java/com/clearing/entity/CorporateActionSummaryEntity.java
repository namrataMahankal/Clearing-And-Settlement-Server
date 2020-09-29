package com.clearing.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@IdClass(CorporateActionSummaryId.class)
@Table(name="corporate_action_summary")
public class CorporateActionSummaryEntity implements Serializable {
	
	
	@Id
	private int securityId;
	@Id
	private int clearingMemberId;
	private int initialShareBalance;
	private int finalShareBalance;
	private String action;
	private String parameter;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="securityId",insertable=false, updatable=false)
	private SecuritiesEntity securityEntity;

	
	public CorporateActionSummaryEntity(int clearingMemberId, int securityId, int initialShareBalance, int finalShareBalance,
			String action, String parameter, SecuritiesEntity securityEntity) {
		
		this.clearingMemberId = clearingMemberId;
		this.securityId = securityId;
		this.initialShareBalance = initialShareBalance;
		this.finalShareBalance = finalShareBalance;
		this.action = action;
		this.parameter = parameter;
		this.securityEntity = securityEntity;
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


	public int getInitialShareBalance() {
		return initialShareBalance;
	}


	public void setInitialShareBalance(int initialShareBalance) {
		this.initialShareBalance = initialShareBalance;
	}


	public int getFinalShareBalance() {
		return finalShareBalance;
	}


	public void setFinalShareBalance(int finalShareBalance) {
		this.finalShareBalance = finalShareBalance;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}

	public String getParameter() {
		return parameter;
	}


	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	public SecuritiesEntity getSecurityEntity() {
		return securityEntity;
	}


	public void setSecurityEntity(SecuritiesEntity securityEntity) {
		this.securityEntity = securityEntity;
	}


	public CorporateActionSummaryEntity() {
	}

}