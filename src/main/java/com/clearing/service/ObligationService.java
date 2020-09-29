package com.clearing.service;

import java.util.HashMap;
import java.util.List;

import com.clearing.json.EquityObligations;
import com.clearing.json.Obligation;

public interface ObligationService {
	
	Obligation getObligations(int id, String name);
	
	List<EquityObligations> getEquityObligations(int id);
	HashMap<String,List<EquityObligations>> getAllEquityObligations();
}
