package com.clearing.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.entity.AccountEntity;
import com.clearing.json.Account;
import com.clearing.repository.AccRepo;
import com.clearing.util.AccountUtil;

@Service
public class AccServiceImpl implements AccService{

	
	@Autowired
	private AccRepo accRep;
	
	@Override
	public String getAuth(Account account) {
		
		try {
		      List<AccountEntity> accEntityList = accRep.findById(account.getUserId());
		      return AccountUtil.getAuth_Token(accEntityList, account.getPswd());
		    }
		    catch(Exception e) {
		    	e.printStackTrace();
		    	return "exception";
		    }
	}

}
