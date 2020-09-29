package com.clearing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clearing.json.Obligation;
import com.clearing.service.MappingServiceImpl;
import com.clearing.service.ObligationService;

@RestController
@RequestMapping("/clearingmember")
public class ObligatonController {

	@Autowired
	ObligationService obligationService;
	
	@Autowired
	private MappingServiceImpl map ;
	
	@GetMapping(value="/obligations/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Obligation getObligations(@PathVariable("name")String name) {
		return obligationService.getObligations(map.getId(name),name);
	}
	
}
