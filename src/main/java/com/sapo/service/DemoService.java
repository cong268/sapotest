package com.sapo.service;

import java.util.List;

import com.sapo.dto.CardDto;
import com.sapo.dto.CardTypeDto;
import com.sapo.dto.TransactionParam;

public interface DemoService {
	public Boolean updateConfig(int rate);
	public Boolean transactionProcess (TransactionParam param);
	public Boolean createCardType (List<CardTypeDto> params);
	public Boolean createCard (List<CardDto> params);
}
