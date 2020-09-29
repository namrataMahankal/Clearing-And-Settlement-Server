package com.clearing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clearing.entity.AccountEntity;
import com.clearing.json.Account;
import com.clearing.service.AccService;

@RestController
@RequestMapping("/acclogin")
public class AccountController {
     
	 @Autowired
	 private AccService accService;
	 
	 Account account = new Account(101,"gspass","CM","authit");
	 
     @GetMapping(value="/credentials", produces=MediaType.APPLICATION_JSON_VALUE)
	 //public String getAuth(@RequestBody Account account) {
     public String getAuth(Account account) {	 
    	 return accService.getAuth(account);
     }
}
