package com.clearing.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.entity.CorporateActionSummary;
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
				cmSummary.add(new EquitySummaryEntity(new EquitySummaryId(securityId,cmId),openingShareQuantity,qty,securitiesRepository.findBySecurityId(securityId),clearingMemberRepository.findByClearingMemberId(cmId)));
			});
			 
			equitySummaryRepository.saveAll(cmSummary);
		});
    }


	@Override
	public ArrayList<CorporateActionSummary> stockSplitAction() {
		List<EquitySummaryEntity> summaryList = IterableUtils.toList(equitySummaryRepository.findAll());
		ArrayList<CorporateActionSummary> corporateActionSummary = new ArrayList<CorporateActionSummary>();
		
		int summaryListLength = IterableUtils.size(summaryList);
		int maxSplits = Math.min(10, summaryListLength);
		int numberOfSplits = rand.nextInt((maxSplits - 2) + 1) + 2;
		System.out.println(numberOfSplits);
		List<Integer> splitRatioList = Arrays.asList(2, 3, 5, 10);
		
		for (int i = 0; i < numberOfSplits; i++) {
			int splitRatio = splitRatioList.get(rand.nextInt(splitRatioList.size()));
			EquitySummaryEntity summaryRecord = summaryList.get(rand.nextInt(summaryListLength));
			
			int newActionCMId = summaryRecord.getId().getClearingMemberId();
			int newActionSecurityId = summaryRecord.getId().getSecurityId();
			int newActionInitialShareBalance = summaryRecord.getNoOfShares()
					+summaryRecord.getSettlementChange();
			int newActionfinalShareBalance = (newActionInitialShareBalance)*splitRatio;
			String newActionParameter = splitRatio+" For 1"; 
			
			CorporateActionSummary newAction = new CorporateActionSummary(newActionCMId,
					newActionSecurityId, newActionInitialShareBalance, newActionfinalShareBalance,
					"Stock Split", newActionParameter);
			corporateActionSummary.add(newAction);			
		}
		
		return corporateActionSummary;
	}


}