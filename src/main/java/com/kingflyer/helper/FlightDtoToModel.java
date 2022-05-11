package com.kingflyer.helper;

import org.springframework.stereotype.Component;

import com.kingflyer.dto.FlightDto;
import com.kingflyer.model.Flight;

@Component
public class FlightDtoToModel {
	
	public Flight convertFlightDtoToModel(FlightDto flightDto) {
		
		Flight flight= new Flight();
		
		flight.setId(flightDto.getId());
		flight.setArrivalDate(flightDto.getArrivalDate());
		flight.setArrivalLocation(flightDto.getArrivalLocation());
		flight.setDepartureLocation(flightDto.getDepartureLocation());
		flight.setDepartureTime(flightDto.getDepartureTime());
		flight.setFare(flightDto.getFare());
		flight.setFleet(flightDto.getFleet());
		flight.setStatus(flightDto.getStatus());
		flight.setBooking(flightDto.getBooking());
		flight.setLocation(flightDto.getLocation());
		
		return flight;
	}
}
