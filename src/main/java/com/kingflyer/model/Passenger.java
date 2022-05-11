package com.kingflyer.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Passenger{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "passenger_id")
	private Integer passengerId;
	
	private String firstName;
	private String lastName;
	private Integer age;
	private Character gender;
	private String flightType;
	
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	@Temporal(TemporalType.DATE)
	private Date bookingDate;
	
	@Column(unique = true)
	private String passportNo;
	
	private String mealPref;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "booking_id")
	private Booking booking;
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name= "payment_id")
	private Payment payment;
	
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public Integer getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getMealPref() {
		return mealPref;
	}
	public void setMealPref(String mealPref) {
		this.mealPref = mealPref;
	}
	
}
