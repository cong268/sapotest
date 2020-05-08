package com.sapo.dto;

public class CardDto {
	private Integer id;
	private String createdOn;
	private String code;
	private String phone;
	private Integer loyaltyCartTypeId;
	private Double point;
	private Double totalSpent;
	private String startDate;
	private String endDate;
	private String modifiedOn;

	public CardDto() {
		super();
	}

	public CardDto(Integer id, String createdOn, String code, String phone, Integer loyaltyCartTypeId, Double point,
			Double totalSpent, String startDate, String endDate, String modifiedOn) {
		super();
		this.id = id;
		this.createdOn = createdOn;
		this.code = code;
		this.phone = phone;
		this.loyaltyCartTypeId = loyaltyCartTypeId;
		this.point = point;
		this.totalSpent = totalSpent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modifiedOn = modifiedOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getLoyaltyCartTypeId() {
		return loyaltyCartTypeId;
	}

	public void setLoyaltyCartTypeId(Integer loyaltyCartTypeId) {
		this.loyaltyCartTypeId = loyaltyCartTypeId;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public Double getTotalSpent() {
		return totalSpent;
	}

	public void setTotalSpent(Double totalSpent) {
		this.totalSpent = totalSpent;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}
