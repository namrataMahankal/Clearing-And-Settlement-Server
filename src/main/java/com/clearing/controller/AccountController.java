package com.clearing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clearing.entity.AccountEntity;
import com.clearing.json.Account;
import com.clearing.services.AccService;

@RestController
@RequestMapping("/acclogin")
public class AccountController {
     
	 @Autowired
	 private AccService accService;
	 
     @GetMapping(value="/credentials/{userID}/{password}", produces=MediaType.APPLICATION_JSON_VALUE)
	 public String getAuth(@PathVariable("userID")long userId,@PathVariable("password")String password) {
    	 return accService.getAuth(userId,password);
     }
}
