package com.clearing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clearing.entity.AccountEntity;
import com.clearing.json.Account;
import com.clearing.json.Credentials;
import com.clearing.repository.AccRepo;
import com.clearing.repository.CorporateActionSummaryRepository;
import com.clearing.repository.EquitySummaryRepository;
import com.clearing.repository.ObligationRepo;
import com.clearing.repository.TradeRepository;
import com.clearing.util.AccountUtil;

@Service
public class AccServiceImpl implements AccService {

	@Autowired
	private AccRepo accountRep;
	@Autowired
	private TradeRepository tradeRepo;
	@Autowired
	private EquitySummaryRepository equitySummaryRepo;
	@Autowired
	private CorporateActionSummaryRepository corpRepo;
	
	@Override
	public Account getAuth(Credentials credentials) {
		
		try {
			  
			List<AccountEntity> accEntityList = accountRep.findByUserName(credentials.getUserName());
			if(accEntityList.size()==0) {
			return null;
			}
			else {
				return AccountUtil.getAuth(accEntityList, credentials.getPassword());
			}
		}
		   catch(Exception e) {
		      e.printStackTrace();
		      return null;
		   }
	 }
	
	@Override
	public void deleteAll() {
		 tradeRepo.deleteAll();
		 equitySummaryRepo.deleteAll();
		 corpRepo.deleteAll();
	}

}
