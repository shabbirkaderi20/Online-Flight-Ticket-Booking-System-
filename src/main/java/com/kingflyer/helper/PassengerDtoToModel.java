package com.kingflyer.helper;

import org.springframework.stereotype.Component;

import com.kingflyer.dto.PassengerDto;
import com.kingflyer.model.Passenger;

@Component
public class PassengerDtoToModel {
	
	public Passenger convertPassengerDtoToModel(PassengerDto passengerDto) {
		
		Passenger passenger= new Passenger();
		
		passenger.setPassengerId(passengerDto.getPassengerId());
		passenger.setFirstName(passengerDto.getFirstName());
		passenger.setLastName(passengerDto.getLastName());
		passenger.setGender(passengerDto.getGender());
		passenger.setAge(passengerDto.getAge());
		passenger.setBookingDate(passengerDto.getBookingDate());
		passenger.setMealPref(passengerDto.getMealPref());
		passenger.setPassportNo(passengerDto.getPassportNo());
		passenger.setFlightType(passengerDto.getFlightType());
		passenger.setPayment(passengerDto.getPayment());
		passenger.setBooking(passengerDto.getBooking());
		
		return passenger;
	}
}
