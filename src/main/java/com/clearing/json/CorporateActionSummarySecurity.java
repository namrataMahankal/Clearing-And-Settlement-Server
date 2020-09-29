package com.clearing.json;

import java.util.List;

public class CorporateActionSummarySecurity {
	
	private String securities;
	private String action;
	private String parameter;
	private List<CorporateActionCMList> cMList;
	public CorporateActionSummarySecurity(String securities, String action, String parameter,
			List<CorporateActionCMList> cMList) {
		super();
		this.securities = securities;
		this.action = action;
		this.parameter = parameter;
		this.cMList = cMList;
	}
	public String getSecurities() {
		return securities;
	}
	public void setSecurities(String securities) {
		this.securities = securities;
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
	public List<CorporateActionCMList> getcMList() {
		return cMList;
	}
	public void setcMList(List<CorporateActionCMList> cMList) {
		this.cMList = cMList;
	}
		
	
}
