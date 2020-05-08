package com.sapo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapo.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
