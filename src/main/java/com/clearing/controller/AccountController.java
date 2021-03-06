package com.clearing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.clearing.json.Account;
import com.clearing.json.Credentials;
import com.clearing.service.AccService;

@RestController
@RequestMapping("/clearing-and-settlement")
@CrossOrigin
public class AccountController {
     
	 @Autowired
	 private AccService accountService;
	 
     @PostMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody Account getAuth(@RequestBody Credentials credential) { 
    	 
    	 return accountService.getAuth(credential);
     
       }
     
     @DeleteMapping("/refresh/all")
     public void refresh() {
       accountService.deleteAll();
     }

}
