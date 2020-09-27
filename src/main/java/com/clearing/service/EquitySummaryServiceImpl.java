package com.clearing.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.IterableUtils;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.entity.EquitySummary;
import com.clearing.repository.EquitySummaryRepository;


@Service
public class EquitySummaryServiceImpl implements EquitySummaryService {

    @Autowired
	private EquitySummaryRepository equitySummaryRepository;
    private static Random rand = new Random(System.currentTimeMillis());

	@Override
    public void addChangeAfterSettlement(HashMap<Integer, HashMap<Integer, Integer>> quantityHashMap){
        quantityHashMap.forEach((cmId,cmData) -> {
			List<EquitySummary> cmSummary = equitySummaryRepository.findByClearingMemberId(cmId);
			cmData.forEach((securityId,qty) -> {
				for(EquitySummary eqs : cmSummary){
					if(securityId == eqs.getSecurityId()){
						eqs.setSettlementChange(qty);
						return;
					}
				}
				int openingShareQuantity = 1 + rand.nextInt(10000);
				cmSummary.add(new EquitySummary(securityId,cmId,openingShareQuantity,qty));
			});
			 
			equitySummaryRepository.saveAll(cmSummary);
		});
    }

}