package com.sapo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.dto.CardTypeDto;
import com.sapo.dto.TransactionParam;
import com.sapo.service.DemoService;

@RestController
public class SapoController {

	@Autowired
	private DemoService demoService;

	@RequestMapping(value = "/updateConfig", method = RequestMethod.GET, produces = "application/json")
	public Boolean updateConfig(@RequestParam(required = true) int rate) {
		return demoService.updateConfig(rate);
	}

	@RequestMapping(value = "/transaction", method = RequestMethod.POST, produces = "application/json")
	public Boolean transaction(@RequestBody TransactionParam param) {
		return demoService.transactionProcess(param);
	}
	
	@RequestMapping(value = "/newCardTypes", method = RequestMethod.POST, produces = "application/json")
	public Boolean newCardTypes(@RequestBody List<CardTypeDto> params) {
		return demoService.createCardType(params);
	}
}
