package com.clearing.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clearing.entity.CorporateActionSummary;
import com.clearing.service.CorporateActionService;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/corporateAction")
public class CorporateActionController {
	
	@Autowired
	private CorporateActionService corporateActionService;

	@GetMapping(path = "/apply")
	public @ResponseBody ArrayList<CorporateActionSummary> apply() {
		ArrayList<CorporateActionSummary> corporateActionList =  corporateActionService.applyCorporateActions();
		return corporateActionList;
	}

}