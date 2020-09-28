package com.clearing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clearing.json.CorporateActionSummary;
import com.clearing.services.CorporateActionSummaryService;
import com.clearing.services.MappingServiceImpl;

@RestController
@RequestMapping("/clearingmember")
public class CorporateActionController {

	@Autowired
	CorporateActionSummaryService corporateActionService;
	
	@Autowired
	private MappingServiceImpl map ;
	
	@GetMapping(value="/corporateactions/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public CorporateActionSummary getCorporateActionSummary(@PathVariable("name")String name) {
		return corporateActionService.getCorporateActionSummary(map.getId(name), name);
	}
	
}
