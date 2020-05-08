package com.sapo.dto;

public class TransactionParam {
	private Integer cardId;
	private double spentNum;
	private String createOn;

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public double getSpentNum() {
		return spentNum;
	}

	public void setSpentNum(double spentNum) {
		this.spentNum = spentNum;
	}

	public String getCreateOn() {
		return createOn;
	}

	public void setCreateOn(String createOn) {
		this.createOn = createOn;
	}

	public TransactionParam() {
		super();
	}

	public TransactionParam(Integer cardId, double spentNum, String createOn) {
		super();
		this.cardId = cardId;
		this.spentNum = spentNum;
		this.createOn = createOn;
	}

}
