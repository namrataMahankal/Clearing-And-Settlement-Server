package com.clearing.services;

import com.clearing.json.Obligation;

public interface ObligationService {
	
	Obligation getObligations(int id, String name);

}
