package com.kingflyer.dto;

import java.util.Date;
import java.util.Set;

import com.kingflyer.model.Booking;
import com.kingflyer.model.Fare;
import com.kingflyer.model.Fleet;
import com.kingflyer.model.FlightStatus;
import com.kingflyer.model.Location;

public class FlightDto {
	
	private Integer id;
	private String departureLocation;
	private String arrivalLocation;
	private Fleet fleet;
	private Booking booking;
	private Fare fare;
	private FlightStatus status;
	private Date departureTime;
	private Date arrivalDate;
	private Set<Location> location;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartureLocation() {
		return departureLocation;
	}
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public Fleet getFleet() {
		return fleet;
	}
	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Fare getFare() {
		return fare;
	}
	public void setFare(Fare fare) {
		this.fare = fare;
	}
	public FlightStatus getStatus() {
		return status;
	}
	public void setStatus(FlightStatus status) {
		this.status = status;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Set<Location> getLocation() {
		return location;
	}
	public void setLocation(Set<Location> location) {
		this.location = location;
	}
	
}
