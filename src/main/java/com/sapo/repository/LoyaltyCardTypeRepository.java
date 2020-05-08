package com.sapo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapo.entity.LoyaltyCardType;

@Repository
public interface LoyaltyCardTypeRepository extends CrudRepository<LoyaltyCardType, Integer> {
	@Query(value = "SELECT * FROM LOYALTY_CARD_TYPE u WHERE u.SPENT_THRESHOLD <= ?1 ORDER BY u.SPENT_THRESHOLD DESC LIMIT 1", nativeQuery = true)
	public LoyaltyCardType getCardTypeByThreshold(double threshold);
}
