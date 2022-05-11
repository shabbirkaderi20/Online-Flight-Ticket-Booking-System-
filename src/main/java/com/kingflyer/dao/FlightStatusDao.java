package com.kingflyer.dao;

import org.springframework.data.repository.CrudRepository;

import com.kingflyer.model.FlightStatus;

public interface FlightStatusDao extends CrudRepository<FlightStatus, Integer>{

}
