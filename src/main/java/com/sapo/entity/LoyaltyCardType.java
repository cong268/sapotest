package com.sapo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LOYALTY_CARD_TYPE")
public class LoyaltyCardType extends BaseEntity {
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;
	@Column(name = "SPENT_THRESHOLD")
	private Double spentThreshold;
	@Column(name = "DURATION")
	private Integer duration;
	@Column(name = "DISCOUNT_PERCENT")
	private double discountPercent;
	@Column(name = "MODIFIED_ON")
	private Date modifiedOn;

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

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public LoyaltyCardType() {
		super();
	}

	public LoyaltyCardType(Integer id, Date createdOn, String name, Double spentThreshold, Integer duration,
			double discountPercent, Date modifiedOn) {
		super(id, createdOn);
		this.name = name;
		this.spentThreshold = spentThreshold;
		this.duration = duration;
		this.discountPercent = discountPercent;
		this.modifiedOn = modifiedOn;
	}

}
