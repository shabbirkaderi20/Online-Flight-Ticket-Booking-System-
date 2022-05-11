package com.kingflyer.service;

import java.util.List;

import com.kingflyer.dto.FlightDto;
import com.kingflyer.model.Flight;

public interface FlightService {
	public Boolean addFlight(FlightDto flightDto, String userName, String password);
	public Boolean modifyFlight(FlightDto flightDto, String userName, String password);
	public Boolean deleteFlight(Integer flightId, String userName, String password);
	
	public List<Flight> searchFlight(String departureLocation, String arrivalLocation);
	public List<Flight> viewSchedule();
}
