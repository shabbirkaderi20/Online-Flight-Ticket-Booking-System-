package com.kingflyer.dao;

import org.springframework.data.repository.CrudRepository;

import com.kingflyer.model.Fleet;

public interface FleetDao extends CrudRepository<Fleet, Integer>{
	
}
