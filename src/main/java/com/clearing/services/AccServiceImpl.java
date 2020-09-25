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
	public String getAuth(long userId, String password) {
		
		try {
		      List<AccountEntity> accEntityList = accRep.findById(userId);
		      return AccountUtil.getAuth_Token(accEntityList, password);
		    }
		    catch(Exception e) {
		    	e.printStackTrace();
		    	return "exception";
		    }
	}

}
