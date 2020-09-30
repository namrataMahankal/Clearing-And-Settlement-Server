package com.clearing.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clearing.json.EquityObligations;
import com.clearing.json.Obligation;
import com.clearing.json.ObligationReport;
import com.clearing.service.MappingServiceImpl;
import com.clearing.service.ObligationService;

@RestController
@RequestMapping("/clearing-and-settlement")
@CrossOrigin(origins="http://localhost:4200")

public class ObligatonController {

	@Autowired
	ObligationService obligationService;

	@Autowired
	private MappingServiceImpl map;

	@GetMapping(value = "/clearing-member/fund-obligations/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Obligation getObligations(@PathVariable("name") String name) {
		return obligationService.getObligations(map.getId(name), name);
	}
	
	@GetMapping(value = "/clearing-member/equity-obligations/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EquityObligations> getEquityObligations(@PathVariable("name") String name) {
		return obligationService.getEquityObligations(map.getId(name));
	}

	@GetMapping(value = "/clearing-house/equity-obligations", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<HashMap<String,String>> getObligationMatrixShares() {
		return obligationService.getAllEquityObligations();
	}

	@GetMapping(value = "/clearing-house/fund-obligations", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Obligation> getObligationMatrixFunds() {
		return obligationService.getAllObligations();
	}
	 
	@GetMapping(value = "/clearing-house/obligation-report", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ObligationReport> getObligationReport() {
		return obligationService.getObligationReport();
	}
}
