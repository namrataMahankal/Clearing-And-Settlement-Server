package com.clearing.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.json.EquityObligations;
import com.clearing.json.Obligation;
import com.clearing.repository.EquityObligationRepo;
import com.clearing.repository.ObligationRepo;
import com.clearing.util.ObligationUtil;

@Service
public class ObligationServiceImpl implements ObligationService {
	
	@Autowired
	private ObligationRepo obligationRepo;
	
	@Autowired
	private EquityObligationRepo equityObligationRepo;
	
	
	@Override
    public Obligation getObligations(int id, String name){
		
		return ObligationUtil.convertToObligation(obligationRepo.findById(id), name); 
		
	}
	
	@Override
    public List<EquityObligations> getEquityObligations(int id){
		
		return ObligationUtil.convertEquityEntityToObligation(equityObligationRepo.findByIdClearingMemberId(id)); 
		
	}

	@Override
	public HashMap<String,List<EquityObligations>> getAllEquityObligations(){
		return ObligationUtil.convertToObligationMatrix(equityObligationRepo.findAll());
	}

	@Override
	public List<Obligation> getAllObligations(){
		return ObligationUtil.convertToObligation(obligationRepo.findAll()); 
	}
	
}
