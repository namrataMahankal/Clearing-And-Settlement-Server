package com.clearing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clearing.json.Obligation;
import com.clearing.services.ObligationService;

@RestController
@RequestMapping("/clearingmember")
public class ObligatonController {

	@Autowired
	ObligationService obligationService;
	
	@GetMapping(value="/obligations/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Obligation getObligations(@PathVariable("id")int id) {
		return obligationService.getObligations(id);
	}
	
}
