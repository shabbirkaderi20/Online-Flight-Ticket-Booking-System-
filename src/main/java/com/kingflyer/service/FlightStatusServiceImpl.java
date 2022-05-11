package com.kingflyer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingflyer.dao.FlightStatusDao;
import com.kingflyer.exception.StatusNotCorrectException;
import com.kingflyer.model.FlightStatus;

@Component
public class FlightStatusServiceImpl implements FlightStatusService{

	@Autowired
	FlightStatusDao flightStatusDao;
	
	@Override
	public FlightStatus addFlightStatus(FlightStatus status) {
		
		if(status!= null) {
			return flightStatusDao.save(status);
		}
		throw new StatusNotCorrectException();
	}

	@Override
	public FlightStatus modifyFlightStatus(FlightStatus status) {
		
		Optional<FlightStatus> optional= flightStatusDao.findById(status.getFlightStatusId());
		
		if(optional.isEmpty()) {
			throw new StatusNotCorrectException();
		}
		
		return flightStatusDao.save(status);
	}

	@Override
	public void deleteFlightStatus(FlightStatus flightStatus) {
		
		Optional<FlightStatus> optional= flightStatusDao.findById(flightStatus.getFlightStatusId());
		
		if(optional.isEmpty()) {
			throw new StatusNotCorrectException();
		}
		
		flightStatusDao.deleteById(flightStatus.getFlightStatusId());


	}
	
}
