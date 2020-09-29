package com.clearing.service;

import com.clearing.json.Account;
import com.clearing.json.Credentials;

public interface AccService {
	 Account getAuth(Credentials credentials);
}
