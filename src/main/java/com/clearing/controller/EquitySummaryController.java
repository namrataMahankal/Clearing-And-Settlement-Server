package com.clearing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clearing.entity.CorporateActionSummary;
import com.clearing.json.Trade;
import com.clearing.service.EquitySummaryService;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/equitySummary")
public class EquitySummaryController {
	
	@Autowired
	private EquitySummaryService equitySummaryService;

	@GetMapping(path = "/generateCA")
	public @ResponseBody ArrayList<CorporateActionSummary> generateCorporateAction() {
		ArrayList<CorporateActionSummary> corporateActionList =  equitySummaryService.stockSplitAction();
		return corporateActionList;
	}

}