package com.clearing.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.service.ClearingMemberService;

@Controller
@RequestMapping(path = "/clearing-member")
public class ClearingMemberController {

	@Autowired
	private ClearingMemberService clearingMemberService;

	@GetMapping(path = "/fund-shortage")
	public @ResponseBody  ArrayList<ClearingMemberEntity> calculateFundSettlement() {
		ArrayList<ClearingMemberEntity> clearingMemberEntity =  clearingMemberService.calculateFundShortage();
		return clearingMemberEntity;
	}

}