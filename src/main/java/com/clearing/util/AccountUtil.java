package com.clearing.util;

import java.util.ArrayList;
import java.util.List;

import com.clearing.entity.AccountEntity;


public class AccountUtil {

	/*public static String get_token(AccountEntity accEntity) {
		return accEntity.getToken();
	}
	*/
	public static String getAuth_Token(List<AccountEntity> accEntityList, String password ) {
		
		System.out.println((accEntityList.get(0)).getPswd()+" & "+password);
		
		try {
		      if(password.equals((accEntityList.get(0)).getPswd())) {
			
			    //String token = null;
				//  token = (String)get_token(accEntityList.get(0));
			   // return "{"+'"'+"auth_token"+'"'+":"+token+"}";
		    	  return "{"+ "valid user" +"}";
		     }
		    else {
		    	return "invalid user";
		    	}
		}
		catch(Exception e){
			e.printStackTrace();
			return "exception";
		}
		   
    }
}
