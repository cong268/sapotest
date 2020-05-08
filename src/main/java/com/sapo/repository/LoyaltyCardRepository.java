package com.sapo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapo.entity.LoyaltyCard;

@Repository
public interface LoyaltyCardRepository extends CrudRepository<LoyaltyCard, Integer> {

}
