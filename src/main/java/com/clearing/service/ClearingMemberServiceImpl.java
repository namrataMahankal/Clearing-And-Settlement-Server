package com.clearing.service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.entity.ClearingMember;
import com.clearing.repository.ClearingMemberRepository;


@Service
public class ClearingMemberServiceImpl implements ClearingMemberService {

    @Autowired
    private ClearingMemberRepository clearingMemberRepository;
    
    @Override
    public void addChangeAfterSettlement(HashMap<Integer, Float> transactionAmountHashMap){
        transactionAmountHashMap.forEach((cmId,fundChange) -> {
			Optional<ClearingMember> obj = clearingMemberRepository.findById(cmId);
			if(obj.isPresent()) {
				ClearingMember cm = obj.get();
				cm.setAmountToPay(-1*fundChange);
				clearingMemberRepository.save(cm);
			}
		});
    }

}
