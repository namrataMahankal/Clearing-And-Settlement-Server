package com.clearing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.json.Obligation;
import com.clearing.repository.ObligationRepo;
import com.clearing.util.ObligationUtil;

@Service
public class ObligationServiceImpl implements ObligationService {
	
	@Autowired
	private ObligationRepo obligationRepo;
	
	
	@Override
    public Obligation getObligations(int id){
		
		return ObligationUtil.convertToObligation(obligationRepo.findById(id)); 
		
	}
}
