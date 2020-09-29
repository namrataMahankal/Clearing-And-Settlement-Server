package com.clearing.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clearing.entity.AccountEntity;
import com.clearing.json.Account;


public class AccountUtil {

	@Autowired
	static Account account = new Account();
	
	public static Account getAuth(List<AccountEntity> accEntityList, String password ) {
		
		try {
			     for(AccountEntity accEntity: accEntityList) {
			          account.setClearingMemberId(accEntity.getClearingMemberId());
			          account.setClearingMemberName(accEntity.getClearingMemberName());
			          account.setPassword(accEntity.getPassword());
			          account.setType(accEntity.getType());
			          account.setUserName(accEntity.getUserName());
			     }
			     if(password.equals(account.getPassword())) {
			    	 return account;
			     }
			     else return null;
		 }
		 catch(Exception e){
			e.printStackTrace();
			return null;
		}
		   
    }
}
