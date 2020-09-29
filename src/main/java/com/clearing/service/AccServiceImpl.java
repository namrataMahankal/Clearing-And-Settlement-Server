package com.clearing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clearing.entity.AccountEntity;
import com.clearing.json.Account;
import com.clearing.json.Credentials;
import com.clearing.repository.AccRepo;
import com.clearing.util.AccountUtil;

@Service
public class AccServiceImpl implements AccService{

	
	@Autowired
	private AccRepo accountRep;
	
	@Override
	public Account getAuth(Credentials credentials) {
		
		try {
			  System.out.println(credentials.getUserName());
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

}
