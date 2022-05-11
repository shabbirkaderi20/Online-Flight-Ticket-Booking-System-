package com.kingflyer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FlightStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "flightstatus_id")
	private Integer flightStatusId;
	
	private Integer remainingEconomySeats;
	private Integer remainingPremiumSeats;
	private Integer remainingBusinessSeats;
	
	@OneToOne(mappedBy= "status")
	private Flight flight;
	
	public Integer getFlightStatusId() {
		return flightStatusId;
	}
	public void setFlightStatusId(Integer flightStatusId) {
		this.flightStatusId = flightStatusId;
	}

	public Integer getRemainingEconomySeats() {
		return remainingEconomySeats;
	}
	public void setRemainingEconomySeats(Integer remainingEconomySeats) {
		this.remainingEconomySeats = remainingEconomySeats;
	}
	public Integer getRemainingPremiumSeats() {
		return remainingPremiumSeats;
	}
	public void setRemainingPremiumSeats(Integer remainingPremiumSeats) {
		this.remainingPremiumSeats = remainingPremiumSeats;
	}
	public Integer getRemainingBusinessSeats() {
		return remainingBusinessSeats;
	}
	public void setRemainingBusinessSeats(Integer remainingBusinessSeats) {
		this.remainingBusinessSeats = remainingBusinessSeats;
	}
	
}
