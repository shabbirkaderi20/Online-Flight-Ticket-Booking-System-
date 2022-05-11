package com.kingflyer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingflyer.dao.AdminDao;
import com.kingflyer.dao.FlightDao;
import com.kingflyer.dto.FlightDto;
import com.kingflyer.exception.AdminNotFoundException;
import com.kingflyer.exception.DataNotCorrectException;
import com.kingflyer.exception.FlightNotFoundException;
import com.kingflyer.exception.NoFlightsFoundException;
import com.kingflyer.exception.PasswordNotMatchedException;
import com.kingflyer.helper.FlightDtoToModel;
import com.kingflyer.model.Admin;
import com.kingflyer.model.Flight;

@Component
public class FlightServiceImpl implements FlightService{

	@Autowired
	FlightDao flightDao;
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	FlightStatusService flightStatusService;
	
	@Autowired
	FleetService fleetService;
	
	@Autowired
	FareService fareService;
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	FlightDtoToModel flightDtoToModel;
	
	@Override
	public Boolean addFlight(FlightDto flightDto, String userName, String password) {
		
		Flight flight= flightDtoToModel.convertFlightDtoToModel(flightDto);
		
		Optional<Admin> optional1= adminDao.findByUserName(userName);
		
		
		if(optional1.isEmpty()) {
			
			throw new AdminNotFoundException();
			
		}else if(!optional1.map(Admin:: getAdminPassword).orElse(password).equals(password)) {
			
			throw new PasswordNotMatchedException();
			
		}
		
		flight.setStatus(flightStatusService.addFlightStatus(flight.getStatus()));
		flight.setFleet(fleetService.addFleet(flight.getFleet()));
		flight.setFare(fareService.addFare(flight.getFare()));
		flight.setLocation(locationService.addLocation(flight.getLocation()));

		flight.setBooking(bookingService.initializeBooking(flight.getBooking()));
		
		flightDao.save(flight);
		
		return true;
	}

	@Override
	public Boolean modifyFlight(FlightDto flightDto, String userName, String password) {
		
		Flight flight= flightDtoToModel.convertFlightDtoToModel(flightDto);
		
		Optional<Flight> optional= flightDao.findById(flight.getId()); 
		Optional<Admin> optional1= adminDao.findByUserName(userName);
		
		
		if(optional1.isEmpty()) {
			
			throw new AdminNotFoundException();
			
		}else if(!optional1.map(Admin:: getAdminPassword).orElse(password).equals(password)) {
			
			throw new PasswordNotMatchedException();
			
		}else if(optional.isEmpty()) {
			
			throw new FlightNotFoundException();
		}
		
		flight.setStatus(flightStatusService.modifyFlightStatus(flight.getStatus()));
		flight.setFleet(fleetService.modifyFleet(flight.getFleet()));
		flight.setFare(fareService.modifyFare(flight.getFare()));
		flight.setLocation(locationService.addLocation(flight.getLocation()));
		flight.setBooking(bookingService.initializeBooking(flight.getBooking()));
		
		flightDao.save(flight);
		
		return true;
	}

	@Override
	public Boolean deleteFlight(Integer flightId, String userName, String password) {
		Optional<Flight> optional= flightDao.findById(flightId); 
		Optional<Admin> optional1= adminDao.findByUserName(userName);
		
		
		if(optional1.isEmpty()) {
			
			throw new AdminNotFoundException();
			
		}else if(!optional1.map(Admin:: getAdminPassword).orElse(password).equals(password)) {
			
			throw new PasswordNotMatchedException();
			
		}else if(optional.isEmpty()) {
			
			throw new FlightNotFoundException();
		}
			flightDao.deleteById(flightId);
			bookingService.deleteBooking(optional.map(Flight::getBooking).orElseThrow(DataNotCorrectException:: new));
			flightStatusService.deleteFlightStatus(optional.map(Flight::getStatus).orElseThrow(DataNotCorrectException:: new));
			fleetService.deleteFleet(optional.map(Flight::getFleet).orElseThrow(DataNotCorrectException:: new));
			fareService.deleteFare(optional.map(Flight::getFare).orElseThrow(DataNotCorrectException:: new));
		return true;
	}
	
	@Override
	public List<Flight> searchFlight(String departureLocation, String arrivalLocation) {
		
		List<Flight> list0= new ArrayList<>();
		List<Flight> list= flightDao.findAllByArrivalLocation(arrivalLocation);
		List<Flight> list1= flightDao.findAllByDepartureLocation(departureLocation);
		
		for(Flight fl: list) {
			for(Flight fl1: list1) {
				if(fl.getDepartureLocation().equals(fl1.getDepartureLocation())){
					list0.add(fl);
				}
			}
		}
		if(list0.isEmpty()) {
			
			throw new NoFlightsFoundException();
		}else {
			
			return list0;
		}
	}

	@Override
	public List<Flight> viewSchedule() {
		
		return (List<Flight>) flightDao.findAll();
	}

}
