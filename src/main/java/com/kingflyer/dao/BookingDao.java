package com.kingflyer.dao;

import org.springframework.data.repository.CrudRepository;

import com.kingflyer.model.Booking;

public interface BookingDao extends CrudRepository<Booking, Integer> {

}
