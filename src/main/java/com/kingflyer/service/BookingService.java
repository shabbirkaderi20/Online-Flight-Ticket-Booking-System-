package com.kingflyer.service;

import com.kingflyer.dto.PassengerDto;
import com.kingflyer.model.Booking;

public interface BookingService {
	
	public Booking initializeBooking(Booking booking);
	public Boolean bookTicket(String userName, String password, Integer flightNo, PassengerDto passengerDto);
	public Boolean cancelTicket(String userName, String password, Integer flightId, String firstName, String lastName);
	public void deleteBooking(Booking booking);
}
