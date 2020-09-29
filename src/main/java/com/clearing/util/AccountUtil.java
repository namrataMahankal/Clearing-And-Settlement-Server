package com.clearing.util;

import java.util.ArrayList;
import java.util.List;

import com.clearing.entity.AccountEntity;
import com.clearing.json.Account;


public class AccountUtil {

	/*public static Account convertAccountEntityToAccount(AccountEntity accountEntity) {
		
		Account account = new Account(accountEntity.getClearingMemberId(),accountEntity.getClearingMemberName(),accountEntity.getPassword(),accountEntity.getType(),accountEntity.getUserName());
	    return account;
	}
	*/
	public static Account getAuth(List<AccountEntity> accEntityList, String password ) {
		
		System.out.println("@util");
		
		try {
		      if(password.equals((accEntityList.get(0)).getPassword())) {
		
		    	  //return convertAccountEntityToAccount(accEntityList.get(0));
		    	 Account account = new Account();
		    	 account.setClearingMemberId(accEntityList.get(0).getClearingMemberId());
		    	 account.setClearingMemberName(accEntityList.get(0).getClearingMemberName());
		    	 account.setPassword(accEntityList.get(0).getPassword());
		    	 account.setType(accEntityList.get(0).getType());
		    	 account.setUserName(accEntityList.get(0).getUserName());
		  	    return account;
		    	  
		     }
		    else {
		    	return null;
		    	}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		   
    }
}
