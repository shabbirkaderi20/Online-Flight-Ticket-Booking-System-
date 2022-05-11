package com.kingflyer.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.kingflyer.model.Booking;
import com.kingflyer.model.Passenger;

public interface PassengerDao extends CrudRepository<Passenger, Integer>{

	public Passenger findByPassportNo(String passportNo);

	public Optional<Passenger> findByFirstName(String firstName);

	public Optional<Passenger> findByLastName(String lastName);

	public Set<Passenger> findAllByBooking(Booking booking);

}
