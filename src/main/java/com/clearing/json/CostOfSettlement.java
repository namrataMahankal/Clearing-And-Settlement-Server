package com.clearing.json;

import java.util.List;

public class CostOfSettlement {

	private String clearingMemberName;
	private CostOfSettlementFund costFunds;
	private List<CostOfSettlementShares> costShares;
	
	
	public CostOfSettlement(String clearingMemberName, CostOfSettlementFund costFunds, List<CostOfSettlementShares> costShares){
		this.clearingMemberName = clearingMemberName;
		this.costFunds = costFunds;
		this.costShares = costShares;
	}
	
	CostOfSettlement(){}
	
	
	public String getClearingMemberName() {
		return clearingMemberName;
	}

	public void setClearingMemberName(String clearingMemberName) {
		this.clearingMemberName = clearingMemberName;
	}

	public CostOfSettlementFund getCostFunds() {
		return costFunds;
	}

	public void setCostFunds(CostOfSettlementFund costFunds) {
		this.costFunds = costFunds;
	}

	public List<CostOfSettlementShares> getCostShares() {
		return costShares;
	}

	public void setCostShares(List<CostOfSettlementShares> costShares) {
		this.costShares = costShares;
	}

	
}
