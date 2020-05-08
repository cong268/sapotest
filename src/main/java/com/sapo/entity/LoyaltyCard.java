package com.sapo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LOYALTY_CARD")
public class LoyaltyCard extends BaseEntity {
	@Column(name = "CODE", unique = true, nullable = false)
	private String code;
	@Column(name = "PHONE", unique = true, nullable = false)
	private String phone;
	@Column(name = "LOYALTY_CART_TYPE_ID")
	private Integer loyaltyCartTypeId;
	@Column(name = "POINT", scale = 2)
	private Double point;
	@Column(name = "TOTAL_SPENT")
	private Double totalSpent;
	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "END_DATE")
	private Date endDate;
	@Column(name = "MODIFIED_ON")
	private Date modifiedOn;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public LoyaltyCard() {
		super();
	}

	public LoyaltyCard(Integer id, Date createdOn, String code, String phone, Integer loyaltyCartTypeId, Double point,
			Double totalSpent, Date startDate, Date endDate, Date modifiedOn) {
		super(id, createdOn);
		this.code = code;
		this.phone = phone;
		this.loyaltyCartTypeId = loyaltyCartTypeId;
		this.point = point;
		this.totalSpent = totalSpent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modifiedOn = modifiedOn;
	}

}
