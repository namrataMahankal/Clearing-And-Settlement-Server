package com.clearing.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.CorporateActionSummaryEntity;
import com.clearing.entity.EquitySummaryEntity;
import com.clearing.entity.EquitySummaryId;
import com.clearing.repository.ClearingMemberRepository;
import com.clearing.repository.EquitySummaryRepository;
import com.clearing.repository.SecuritiesRepository;


@Service
public class EquitySummaryServiceImpl implements EquitySummaryService {

    @Autowired
	private EquitySummaryRepository equitySummaryRepository;
    
    @Autowired
    private ClearingMemberRepository clearingMemberRepository;
    
    @Autowired
    private SecuritiesRepository securitiesRepository;
    
    
    
    private static Random rand = new Random(System.currentTimeMillis());

	
    public void addChangeAfterSettlement(HashMap<Integer, HashMap<Integer, Integer>> quantityHashMap){
      quantityHashMap.forEach((cmId,cmData) -> {
			List<EquitySummaryEntity> cmSummary = equitySummaryRepository.findByIdClearingMemberId(cmId);
			cmData.forEach((securityId,qty) -> {
				for(EquitySummaryEntity eqs : cmSummary){
					if(securityId == eqs.getId().getSecurityId()){
						eqs.setSettlementChange(qty);
						return;
					}
				}
				int openingShareQuantity = 1 + rand.nextInt(10000);
				Optional<ClearingMemberEntity> cmObj = clearingMemberRepository.findById(cmId);
				if(cmObj.isPresent()){
					cmSummary.add(new EquitySummaryEntity(new EquitySummaryId(securityId,cmId),openingShareQuantity,qty,securitiesRepository.findBySecurityId(securityId),cmObj.get()));
				}
				else{
					throw new Error("Clearing Member not found by id");
				}
			});
			 
			equitySummaryRepository.saveAll(cmSummary);
		});
    }
}