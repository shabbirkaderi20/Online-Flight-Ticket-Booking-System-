package com.kingflyer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kingflyer.constant.Constant;
import com.kingflyer.dto.AdminLogin;
import com.kingflyer.dto.DeleteFlight;
import com.kingflyer.dto.FlightDto;
import com.kingflyer.exception.FlightAlreadyExistsException;
import com.kingflyer.exception.FlightNotFoundException;
import com.kingflyer.exception.NoFlightsCurrentlyException;
import com.kingflyer.model.Flight;
import com.kingflyer.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	FlightService flightService;
	@CrossOrigin
	@PostMapping(path= "/addFlight")
	public String addFlight(@RequestBody FlightDto flightDto, @RequestParam String userName, @RequestParam String password) {
		
		boolean isFlightAdded= flightService.addFlight(flightDto, userName, password);
		
		if(isFlightAdded) {
			return Constant.FLIGHT_ADDITION_SUCCESSFULL;
		}
		throw new FlightAlreadyExistsException();
	}
	@CrossOrigin
	@PostMapping("/modifyFlight")
	public String modifyFlight(@RequestBody FlightDto flightDto, @RequestParam String userName, @RequestParam String password) {
		
		boolean isFlightModified= flightService.modifyFlight(flightDto, userName, password);
		
		if(isFlightModified) {
			return Constant.FLIGHT_UPDATE_SUCCESSFULL;
		}
		throw new FlightNotFoundException();
	}
	@CrossOrigin
	@PostMapping("/deleteFlight")
	public String deleteFlight(@RequestBody DeleteFlight deleteFlight) {
		Integer flightId=deleteFlight.flightId;
		String userName=deleteFlight.userName;
		String password=deleteFlight.password;
		
		boolean isFlightDeleted= flightService.deleteFlight(flightId, userName, password);
		
		if(isFlightDeleted) {
			return Constant.FLIGHT_DELETION_SUCCESSFULL;
		}
		throw new FlightNotFoundException();
	}
	@CrossOrigin
	@GetMapping("/searchAllFlights")
	public List<Flight> searchAllFlights(){
		
		List<Flight> flightList= flightService.viewSchedule();
		if(!flightList.isEmpty()) {
			return flightList;
		}
		throw new NoFlightsCurrentlyException();
	}
	@CrossOrigin
	@PostMapping("/searchFlightsByLocation")
	public List<Flight> searchFlightsByLocation(@RequestBody AdminLogin adminLogin){
		
		String departureLocation= adminLogin.userName;
		String arrivalLocation= adminLogin.password;
		return flightService.searchFlight(departureLocation, arrivalLocation);
	}
	
}
