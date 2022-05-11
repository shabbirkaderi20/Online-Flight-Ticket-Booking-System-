package com.kingflyer.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kingflyer.model.Flight;

public interface FlightDao extends CrudRepository<Flight,Integer> {

	public List<Flight> findAllByDepartureLocation(String departureLocation);

	public List<Flight> findAllByArrivalLocation(String arrivalLocation);
	
}
