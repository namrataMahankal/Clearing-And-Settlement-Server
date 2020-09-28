package com.clearing.json;

import java.util.ArrayList;
import java.util.List;

public class CorporateActionSummary {

	
	private String clearingMemberName;
    List<CorporateActionList> actionList = new ArrayList<CorporateActionList>();
	
    public CorporateActionSummary() {}
	public CorporateActionSummary(String clearingMemberName, List<CorporateActionList> actionList) {
		this.clearingMemberName = clearingMemberName;
		this.actionList = actionList;
	}
	
	
	public String getClearingMemberName() {
		return clearingMemberName;
	}

	public void setClearingMemberId(String clearingMemberName) {
		this.clearingMemberName = clearingMemberName;
	}

	public List<CorporateActionList> getActionList() {
		return actionList;
	}

	public void setActionList(List<CorporateActionList> actionList) {
		this.actionList = actionList;
	}
	
	
}
