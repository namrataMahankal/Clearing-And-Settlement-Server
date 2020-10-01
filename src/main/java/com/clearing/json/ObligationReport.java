package com.clearing.json;

import java.util.List;

public class ObligationReport {
	private String cMName;
	private double fundsObligation;
	private List<EquityObligations> shareListObligation;

	public ObligationReport() {
		super();
	}

	public ObligationReport(String cMName, double fundsObligation, List<EquityObligations> shareListObligation) {
		super();
		this.cMName = cMName;
		this.fundsObligation = fundsObligation;
		this.shareListObligation = shareListObligation;
	}

	public String getCMName() {
		return cMName;
	}

	public void setCMName(String cMName) {
		this.cMName = cMName;
	}

	public double getFundsObligation() {
		return fundsObligation;
	}

	public void setFundsObligation(double fundsObligation) {
		this.fundsObligation = fundsObligation;
	}

	public List<EquityObligations> getShareListObligation() {
		return shareListObligation;
	}

	public void setShareListObligation(List<EquityObligations> shareListObligation) {
		this.shareListObligation = shareListObligation;
	}

}
