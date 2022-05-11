package com.kingflyer.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "flight_Id")
	private Integer id;
	
	private String departureLocation;
	private String arrivalLocation;
	
	@OneToOne
	@JoinColumn(name= "fleet_id")
	private Fleet fleet;
	
	@OneToOne
	@JoinColumn(name= "booking_id")
	private Booking booking;
	
	@OneToOne
	@JoinColumn(name= "fare_id")
	private Fare fare;

	public Set<Location> getLocation() {
		return location;
	}
	public void setLocation(Set<Location> location) {
		this.location = location;
	}
	@OneToOne
	@JoinColumn(name= "flightStatus_id")
	private FlightStatus status;
	
	@Temporal(TemporalType.DATE)
	private Date departureTime;
	
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	
	@OneToMany
	@JoinColumn(name= "locations")
	private Set<Location> location;

	public Fare getFare() {
		return fare;
	}
	public void setFare(Fare fare) {
		this.fare = fare;
	}
	
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
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}	
}
