package com.clearing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.EquitySummaryEntity;
import com.clearing.json.CostOfSettlementFund;
import com.clearing.json.CostOfSettlementShares;
import com.clearing.json.EquitySummary;
import com.clearing.repository.ClearingMemberRepository;
import com.clearing.repository.EquitySummaryRepository;
import com.clearing.util.EquitySummaryUtil;

@Service
public class ClearingMemberServiceImpl implements ClearingMemberService {

	@Autowired
	private ClearingMemberRepository clearingMemberRepository;
	@Autowired
	private EquitySummaryRepository equitySummaryRepository;

	@Override
	public void addChangeAfterSettlement(HashMap<Integer, Float> transactionAmountHashMap) {
		transactionAmountHashMap.forEach((cmId, fundChange) -> {
			Optional<ClearingMemberEntity> obj = clearingMemberRepository.findById(cmId);
			if (obj.isPresent()) {
				ClearingMemberEntity cm = obj.get();
				cm.setAmountToPay(fundChange);
				clearingMemberRepository.save(cm);
			}
		});
	}

	@Override
	public float getCMOpeningFundBalance(String cMName) {
		// TODO Auto-generated method stub
		return clearingMemberRepository.findByClearingMemberName(cMName).getClearingMemberFundBalance();
	}

	@Override
	public List<EquitySummary> getCMOpeningShareBalance(String cMName) {
		// TODO Auto-generated method stub
		return EquitySummaryUtil
				.convertEquitySummaryEntityListIntoEquitySummaryList(equitySummaryRepository.findByIdClearingMemberId(
						clearingMemberRepository.findByClearingMemberName(cMName).getClearingMemberId()));
		// return null;
	}

	@Override
	public ArrayList<ClearingMemberEntity> calculateFundShortage() {
		List<ClearingMemberEntity> cmList = IterableUtils.toList(clearingMemberRepository.findAll());
		ArrayList<ClearingMemberEntity> fundSettlementList = new ArrayList<ClearingMemberEntity>();

		for (ClearingMemberEntity cm : cmList) {
			float amount = cm.getClearingMemberFundBalance() + cm.getAmountToPay();
			if (amount < 0) {
				amount *= -1;
				float netPayable = amount * cm.getInterestRate();
				cm.setNetPayable(netPayable);
				cm.setShortage(amount);
				fundSettlementList.add(cm);
				clearingMemberRepository.save(cm);
			}
		}
		return fundSettlementList;
	}

	@Override
	public CostOfSettlementFund getCostOfSettlementFund(String cMName) {
		// TODO Auto-generated method stub
		ClearingMemberEntity cm = clearingMemberRepository.findByClearingMemberName(cMName);
		return new CostOfSettlementFund(cm.getShortage(), cm.getInterestRate(), cm.getNetPayable());
	}

	@Override
	public List<CostOfSettlementShares> getCostOfSettlementShares(String cMName) {
		// TODO Auto-generated method stub
		ClearingMemberEntity cm = clearingMemberRepository.findByClearingMemberName(cMName);
		List<EquitySummaryEntity> shares = equitySummaryRepository.findByIdClearingMemberId(cm.getClearingMemberId());
		List<CostOfSettlementShares> sharesCost = new ArrayList<CostOfSettlementShares>();
		for (EquitySummaryEntity share : shares) {
			if(share.getShortage()>0)
			sharesCost.add(new CostOfSettlementShares(share.getSecurity().getSecurityName(), share.getShortage(),
					share.getSecurity().getInterestRate(), share.getNetPayable()));
		}
		return sharesCost;
	}

}
