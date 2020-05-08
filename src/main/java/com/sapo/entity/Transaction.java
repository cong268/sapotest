package com.sapo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction extends BaseEntity {
	@Column(name = "LOYALTY_CARD_ID", nullable = false)
	private Integer loyaltyCardId;
	@Column(name = "POINT_ADJUST")
	private Double pointAdjust;
	@Column(name = "SPENT_ADJUST")
	private Double spentAdjust;

	public Integer getLoyaltyCardId() {
		return loyaltyCardId;
	}

	public void setLoyaltyCardId(Integer loyaltyCardId) {
		this.loyaltyCardId = loyaltyCardId;
	}

	public Double getPointAdjust() {
		return pointAdjust;
	}

	public void setPointAdjust(Double pointAdjust) {
		this.pointAdjust = pointAdjust;
	}

	public Double getSpentAdjust() {
		return spentAdjust;
	}

	public void setSpentAdjust(Double spentAdjust) {
		this.spentAdjust = spentAdjust;
	}

	public Transaction() {
		super();
	}

	public Transaction(Integer id, Date createdOn, Integer loyaltyCardId, Double pointAdjust, Double spentAdjust) {
		super(id, createdOn);
		this.loyaltyCardId = loyaltyCardId;
		this.pointAdjust = pointAdjust;
		this.spentAdjust = spentAdjust;
	}

}
