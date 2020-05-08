package com.sapo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapo.entity.Config;

@Repository
public interface ConfigRepository extends CrudRepository <Config, String>{

}
