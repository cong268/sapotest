package com.sapo.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapo.dto.CardDto;
import com.sapo.dto.CardTypeDto;
import com.sapo.dto.TransactionParam;
import com.sapo.service.DemoService;

public class TransactionTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Autowired
	private DemoService demoService;

	@Test
	public void updateConfig() throws Exception {
		String uri = "/updateConfig";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE).param("rate", "10"))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("true", content);
	}

	@Test
	public void transaction() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/updateConfig")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
				.param("rate","100000"));
		demoService.createCardType(listLoyaltyCardType());
		demoService.createCard(listLoyaltyCard());
		List<TransactionParam> lst = listParam();
		for (TransactionParam param : lst) {
			MvcResult mvcResult = mvc
					.perform(MockMvcRequestBuilders.post("/transaction")
							.contentType(MediaType.APPLICATION_JSON_UTF8)
			                .accept(MediaType.APPLICATION_JSON_UTF8)
							.content(new ObjectMapper().writeValueAsString(param)))
							.andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			assertEquals("true", content);
		}
	}

	private List<CardTypeDto> listLoyaltyCardType() {
		List<CardTypeDto> list = new ArrayList<>();
		list.add(new CardTypeDto(1, "Thẻ chuẩn", 0d, 365, 1, "12/18/2019", "12/18/2019"));
		list.add(new CardTypeDto(2, "Thẻ bạc", 5000000d, 365, 2, "12/18/2019", "12/18/2019"));
		list.add(new CardTypeDto(3, "Thẻ vàng", 10000000d, 365, 5, "12/18/2019", "12/18/2019"));
		list.add(new CardTypeDto(4, "Thẻ bạch kim", 20000000d, 365, 7, "12/18/2019", "12/18/2019"));
		list.add(new CardTypeDto(5, "Thẻ kim cương", 50000000d, 365, 10, "12/18/2019", "12/18/2019"));
		return list;
	}

	private List<CardDto> listLoyaltyCard() {
		List<CardDto> list = new ArrayList<>();
		list.add(new CardDto(1, "12/18/2019", "LT0001", "0987654321", 1, 23.45, 2345000d, "12/18/2019", "12/18/2020",
				"12/18/2019"));
		list.add(new CardDto(2, "5/17/2019", "LT0002", "0987654322", 2, 0d, 7987000d, "10/17/2019", "10/17/2020",
				"12/17/2019"));
		list.add(new CardDto(3, "4/15/2019", "LT0003", "0987654323", 3, -12d, 15400000d, "11/12/2019", "11/12/2020",
				"11/27/2019"));
		list.add(new CardDto(4, "3/12/2019", "HT0001", "0987654324", 4, 30d, 30000000d, "5/23/2019", "5/23/2020",
				"8/23/2019"));
		list.add(new CardDto(5, "2/1/2019", "HO0002", "0987654325", 5, 39d, 54000000d, "7/27/2019", "7/27/2020",
				"11/27/2019"));
		return list;
	}

	private List<TransactionParam> listParam() {
		List<TransactionParam> list = new ArrayList<>();
		list.add(new TransactionParam(1, 3040000, "12/18/2019"));
		list.add(new TransactionParam(1, 200109, "12/19/2019"));
		list.add(new TransactionParam(2, -3000000, "12/18/2019"));
		list.add(new TransactionParam(4, -3000000, "12/19/2019"));
		list.add(new TransactionParam(3, 1000000, "12/18/2019"));
		list.add(new TransactionParam(5, -5000000, "12/18/2019"));
		list.add(new TransactionParam(2, 6104000, "12/18/2019"));
		list.add(new TransactionParam(3, 200400, "12/18/2019"));
		list.add(new TransactionParam(1, -3040000, "12/19/2019"));
		list.add(new TransactionParam(5, 2100000, "12/18/2019"));
		list.add(new TransactionParam(3, 199000, "12/18/2019"));
		list.add(new TransactionParam(1, 2600000, "12/19/2019"));
		list.add(new TransactionParam(4, -7000000, "12/19/2019"));
		list.add(new TransactionParam(5, 300000, "12/18/2019"));
		list.add(new TransactionParam(3, 1000000, "12/19/2019"));
		list.add(new TransactionParam(1, 5300000, "12/19/2019"));
		list.add(new TransactionParam(2, 105000, "12/19/2019"));
		list.add(new TransactionParam(3, 5000000, "12/19/2019"));
		list.add(new TransactionParam(4, -1000000, "12/19/2019"));
		list.add(new TransactionParam(5, 204000, "12/18/2019"));
		return list;
	}
}
