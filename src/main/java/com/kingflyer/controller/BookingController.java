package com.kingflyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kingflyer.constant.Constant;
import com.kingflyer.dto.PassengerDto;
import com.kingflyer.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	@CrossOrigin
	@PostMapping("/bookTicket/{userName}/{password}/{flightId}/{passenger}")
	public String bookTicket(@RequestParam String userName, @RequestParam String password, @RequestParam int flightId, @RequestBody PassengerDto passengerDto){
		
		boolean isTicketBooked= bookingService.bookTicket(userName, password, flightId, passengerDto);
		
		if(isTicketBooked) {
			return Constant.BOOKING_SUCCESSFULL;
		}
		
		return Constant.BOOKING_UNSUCCESSFULL;
	}
	@CrossOrigin
	@PostMapping("/cancelTicket/{userName}/{password}/{firstName}/{lastName}/{flightId}")
	public String cancelTicket(@RequestParam String userName, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer flightId){
		
		boolean isTicketBooked= bookingService.cancelTicket(userName, password, flightId, firstName, lastName);
		
		if(isTicketBooked) {
			return Constant.CANCELATION_SUCCESSFULL;
		}
		
		return Constant.CANCELATION_UNSUCCESSFULL;
	}
}
