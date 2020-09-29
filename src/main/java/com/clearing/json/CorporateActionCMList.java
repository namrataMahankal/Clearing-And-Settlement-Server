package com.clearing.json;

public class CorporateActionCMList {
	private String cm;
	private int initialShares;
	private int currentShares;

	public CorporateActionCMList(String cm, int initialShares, int currentShares) {
		super();
		this.cm = cm;
		this.initialShares = initialShares;
		this.currentShares = currentShares;
	}

	public String getCm() {
		return cm;
	}

	public void setCm(String cm) {
		this.cm = cm;
	}

	public int getInitialShares() {
		return initialShares;
	}

	public void setInitialShares(int initialShares) {
		this.initialShares = initialShares;
	}

	public int getCurrentShares() {
		return currentShares;
	}

	public void setCurrentShares(int currentShares) {
		this.currentShares = currentShares;
	}

}
