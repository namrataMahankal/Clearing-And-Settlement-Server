package com.clearing.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clearing.entity.CorporateActionEntity;
import com.clearing.entity.CorporateActionSummaryEntity;
import com.clearing.service.CorporateActionService;


import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;


import com.clearing.json.CorporateActionSummary;
import com.clearing.json.CorporateActionSummarySecurity;
import com.clearing.service.MappingServiceImpl;



@Controller // This means that this class is a Controller
@RequestMapping(path = "/clearing-and-settlement")
@CrossOrigin

public class CorporateActionController {
	
	@Autowired
	private CorporateActionService corporateActionService;

	@Autowired
	private MappingServiceImpl map ;

	@GetMapping(path = "/corporate-actions")
	public @ResponseBody List<CorporateActionEntity> showCorporateActions() {
		List<CorporateActionEntity> corporateActionList =  corporateActionService.showCorporateActions();
		return corporateActionList;
	}


	@GetMapping(path = "/corporate-actions/apply")
	public @ResponseBody void apply() {
		// Applying Corporate Actions
		corporateActionService.applyCorporateActions();
	}

	@GetMapping(path="/corporate-actions/summary")
	public @ResponseBody List<CorporateActionSummaryEntity> showCorporateActionsSummary() {
		List<CorporateActionSummaryEntity> corporateActionSummaryList =  corporateActionService.showCorporateActionsSummary();
		return corporateActionSummaryList;
	}
	
	@GetMapping(value="/corporate-actions/cm/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CorporateActionSummary getCorporateActionSummary(@PathVariable("name")String name) {
		return corporateActionService.getCorporateActionSummary(map.getId(name), name);
	}
	
	@GetMapping(value="/corporate-actions/clearing-house/summary", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CorporateActionSummarySecurity> getCorporateActionSummarySecurity() {
		return corporateActionService.getCorporateActionSummarySecurity();
	}

}
