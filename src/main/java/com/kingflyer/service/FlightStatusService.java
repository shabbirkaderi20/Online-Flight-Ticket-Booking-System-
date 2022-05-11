package com.kingflyer.service;

import com.kingflyer.model.FlightStatus;

public interface FlightStatusService {

	public FlightStatus addFlightStatus(FlightStatus status);

	public FlightStatus modifyFlightStatus(FlightStatus status);

	public void deleteFlightStatus(FlightStatus flightStatus);

}
