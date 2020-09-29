package com.clearing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clearing.entity.CorporateActionEntity;
import com.clearing.entity.CorporateActionSummaryEntity;
import com.clearing.service.CorporateActionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clearing.json.CorporateActionSummary;
import com.clearing.service.CorporateActionSummaryService;
import com.clearing.service.MappingServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller // This means that this class is a Controller
@RequestMapping(path = "/clearing-and-settlement")
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


	// @GetMapping(path = "/corporate-actions/apply")
	// public @ResponseBody void apply() {
	// 	ArrayList<CorporateActionSummaryEntity> corporateActionSummaryList =  corporateActionService.applyCorporateActions();
	// 	// return corporateActionSummaryList;
	// }

	@GetMapping(path="/corporate-actions/summary")
	public @ResponseBody List<CorporateActionSummaryEntity> showCorporateActionsSummary() {
		List<CorporateActionSummaryEntity> corporateActionSummaryList =  corporateActionService.showCorporateActionsSummary();
		return corporateActionSummaryList;
	}
	
	@GetMapping(value="/corporate-actions/cm/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CorporateActionSummary getCorporateActionSummary(@PathVariable("name")String name) {
		return corporateActionService.getCorporateActionSummary(map.getId(name), name);
	}

}
