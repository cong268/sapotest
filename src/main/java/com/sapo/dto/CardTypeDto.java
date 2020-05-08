package com.sapo.dto;

public class CardTypeDto {
	private Integer id;
	private String name;
	private Double spentThreshold;
	private Integer duration;
	private double discountPercent;
	private String createOn;
	private String modifiedOn;

	public CardTypeDto() {
		super();
	}

	public CardTypeDto(Integer id, String name, Double spentThreshold, Integer duration, double discountPercent,
			String createOn, String modifiedOn) {
		super();
		this.id = id;
		this.name = name;
		this.spentThreshold = spentThreshold;
		this.duration = duration;
		this.discountPercent = discountPercent;
		this.createOn = createOn;
		this.modifiedOn = modifiedOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSpentThreshold() {
		return spentThreshold;
	}

	public void setSpentThreshold(Double spentThreshold) {
		this.spentThreshold = spentThreshold;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getCreateOn() {
		return createOn;
	}

	public void setCreateOn(String createOn) {
		this.createOn = createOn;
	}

	public String getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}
