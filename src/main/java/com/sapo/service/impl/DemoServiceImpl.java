package com.sapo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapo.dto.CardDto;
import com.sapo.dto.CardTypeDto;
import com.sapo.dto.TransactionParam;
import com.sapo.entity.Config;
import com.sapo.entity.LoyaltyCard;
import com.sapo.entity.LoyaltyCardType;
import com.sapo.entity.Transaction;
import com.sapo.repository.ConfigRepository;
import com.sapo.repository.LoyaltyCardRepository;
import com.sapo.repository.LoyaltyCardTypeRepository;
import com.sapo.repository.TransactionRepository;
import com.sapo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	private static final String RATE_COUNT = "RATE_COUNT";

	@Autowired
	private ConfigRepository configRepos;
	@Autowired
	private LoyaltyCardRepository loyaltyCardRepos;
	@Autowired
	private LoyaltyCardTypeRepository loyaltyCardTypeRepos;
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Boolean updateConfig(int rate) {
		Config config = configRepos.findOne(RATE_COUNT);
		if (config == null) {
			config = new Config(RATE_COUNT, rate);
		} else {
			config.setValue(rate);
		}

		try {
			configRepos.save(config);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean transactionProcess(TransactionParam param) {
		LoyaltyCard card = loyaltyCardRepos.findOne(param.getCardId());
		if (card == null) {
			System.out.println("Not found LoyaltyCard by id = " + param.getCardId());
			return false;
		}
		Config config = configRepos.findOne(RATE_COUNT);
		double pointSpent = param.getSpentNum() / config.getValue();
		try {
			Date createOn = new SimpleDateFormat("MM/dd/yyyy").parse(param.getCreateOn());
			Transaction transaction = new Transaction(null, createOn, card.getId(), pointSpent, param.getSpentNum());
			updateLoyaltyCard(param, card, pointSpent);
			transactionRepository.save(transaction);
			loyaltyCardRepos.save(card);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private void updateLoyaltyCard(TransactionParam param, LoyaltyCard card, double pointSpent) {
		double totalSpent = param.getSpentNum() + card.getTotalSpent();
		LoyaltyCardType cardType = loyaltyCardTypeRepos.getCardTypeByThreshold(totalSpent);
		if (cardType == null) {
			card.setLoyaltyCartTypeId(null);
			card.setStartDate(null);
			card.setEndDate(null);
		} else {
			if (card.getLoyaltyCartTypeId() == null || card.getLoyaltyCartTypeId() != cardType.getId()) {
				card.setLoyaltyCartTypeId(cardType.getId());
				Calendar c = Calendar.getInstance();
				Date currentDate = c.getTime();
				card.setStartDate(currentDate);
				c.add(Calendar.DATE, cardType.getDuration());
				card.setEndDate(c.getTime());
			}
		}
		double totalPoint = Math.ceil((card.getPoint() + pointSpent)* 100) / 100;
		card.setPoint(totalPoint);
		card.setTotalSpent(totalSpent);
		card.setModifiedOn(new Date());
	}

	@Override
	public Boolean createCardType(List<CardTypeDto> params) {
		try {
			for (CardTypeDto param : params) {
				LoyaltyCardType cardType = new LoyaltyCardType();
				cardType.setId(param.getId());
				cardType.setName(param.getName());
				cardType.setDiscountPercent(param.getDiscountPercent());
				cardType.setDuration(param.getDuration());
				cardType.setSpentThreshold(param.getSpentThreshold());
				cardType.setCreatedOn(convertDate(param.getCreateOn()));
				cardType.setModifiedOn(convertDate(param.getModifiedOn()));
				loyaltyCardTypeRepos.save(cardType);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean createCard(List<CardDto> params) {
		try {
			for (CardDto param : params) {
				LoyaltyCard card = new LoyaltyCard();
				card.setId(param.getId());
				card.setCode(param.getCode());
				card.setCreatedOn(convertDate(param.getCreatedOn()));
				card.setEndDate(convertDate(param.getEndDate()));
				card.setLoyaltyCartTypeId(param.getLoyaltyCartTypeId());
				card.setModifiedOn(convertDate(param.getModifiedOn()));
				card.setPhone(param.getPhone());
				card.setPoint(param.getPoint());
				card.setStartDate(convertDate(param.getStartDate()));
				card.setTotalSpent(param.getTotalSpent());
				loyaltyCardRepos.save(card);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private Date convertDate(String dateStr) {
		Date date = null;
		try {
			if (dateStr != null) {
				date = new SimpleDateFormat("MM/dd/yyyy").parse(dateStr);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
