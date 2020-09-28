package com.clearing.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "corporate_action")
public class CorporateActionEntity {
	@Id
	private int corporateActionId;
    private int securityId;
    private String action;    
    private String parameter;

    public int getSecurityId() {
		return securityId;
	}

	public void setSecurityId(int securityId) {
		this.securityId = securityId;
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

	public CorporateActionEntity(){

	}

}
