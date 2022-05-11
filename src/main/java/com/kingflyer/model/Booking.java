package com.kingflyer.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "booking_id")
	private Integer bookingId;
	
	@Column(unique = true)
	private Long bookingNumber;
	
	@Temporal(TemporalType.DATE)
	private Date travelDate;
	
	private Double totalCost;
	
	@OneToOne(mappedBy= "booking")
	private Flight flightBooked;
	
	@OneToMany(mappedBy= "booking", cascade= CascadeType.ALL)
	private Set<Passenger> passengers;
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer id) {
		this.bookingId = id;
	}
	public Long getBookingNumber() {
		return bookingNumber;
	}
	public void setBookingNumber(Long bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

}
