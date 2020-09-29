package com.clearing.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.entity.ClearingMemberEntity;
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
		return clearingMemberRepository.findByClearingMemberName(cMName).getClearingMemberFundBalance();
	}

	@Override
	public List<EquitySummary> getCMOpeningShareBalance(String cMName) {
		return EquitySummaryUtil
				.convertEquitySummaryEntityListIntoEquitySummaryList(equitySummaryRepository.findByIdClearingMemberId(
						clearingMemberRepository.findByClearingMemberName(cMName).getClearingMemberId()));
		// return null;
	}

	@Override
	public void calculateFundShortage() {
		List<ClearingMemberEntity> cmList = IterableUtils.toList(clearingMemberRepository.findAll());

		for (ClearingMemberEntity cm : cmList) {
			float amount = cm.getClearingMemberFundBalance() + cm.getAmountToPay();
			if (amount < 0) {
				amount *= -1;
				float netPayable = amount * cm.getInterestRate();
				cm.setNetPayable(netPayable);
				cm.setShortage(amount);
				clearingMemberRepository.save(cm);
			}
		}
	}

}
