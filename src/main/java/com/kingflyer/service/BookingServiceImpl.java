package com.kingflyer.service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingflyer.dao.BookingDao;
import com.kingflyer.dao.ContactDao;
import com.kingflyer.dao.FareDao;
import com.kingflyer.dao.FlightDao;
import com.kingflyer.dao.FlightStatusDao;
import com.kingflyer.dao.PassengerDao;
import com.kingflyer.dao.PaymentDao;
import com.kingflyer.dao.UserDao;
import com.kingflyer.dto.PassengerDto;
import com.kingflyer.exception.BookingNotCorrectException;
import com.kingflyer.exception.DataNotCorrectException;
import com.kingflyer.exception.FlightNotFoundException;
import com.kingflyer.exception.NoSeatsAvailableException;
import com.kingflyer.exception.PasswordNotMatchedException;
import com.kingflyer.exception.PaymentFailedException;
import com.kingflyer.exception.UserNotFoundException;
import com.kingflyer.helper.PassengerDtoToModel;
import com.kingflyer.model.Booking;
import com.kingflyer.model.Flight;
import com.kingflyer.model.FlightStatus;
import com.kingflyer.model.Passenger;
import com.kingflyer.model.Payment;
import com.kingflyer.model.User;

@Component
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ContactService contactData;
	
	@Autowired
	ContactDao contactDao;
	
	@Autowired
	FlightDao flightDao;
	
	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	PassengerDao passengerDao;
	
	@Autowired
	FareDao faredao;
	
	@Autowired
	FlightStatusDao flightStatusDao;
	
	@Autowired
	PassengerDtoToModel passengerDtoToModel;
	
	@Override
	public Boolean bookTicket(String userName,String password, Integer flightNo, PassengerDto passengerDto) {

	Passenger passenger= passengerDtoToModel.convertPassengerDtoToModel(passengerDto);


	Date date= new Date();

	Optional<User> optional= userDao.findByUserName(userName);

	if(optional.isEmpty()) {
	//Direct to login page
	return false;
	}
	if(!password.equals(optional.map(User:: getPassword).orElse(""))){

	throw new PasswordNotMatchedException();
	}


	Flight flight= flightDao.findById(flightNo).orElseThrow(FlightNotFoundException:: new);
	Double fare= 0d;
	Integer remainingSeats= 0;

	if(flightNo== null || passenger== null) {

	throw new DataNotCorrectException();
	}

	if(passenger.getFlightType().equals("Economy")) {

	fare= flight.getFare().getEconomyFare();
	remainingSeats= flight.getStatus().getRemainingEconomySeats();

	}
	if(passenger.getFlightType().equals("Business")) {

	fare= flight.getFare().getBusinessFare();
	remainingSeats= flight.getStatus().getRemainingBusinessSeats();

	}
	if(passenger.getFlightType().equals("Premium")) {

	fare= flight.getFare().getPremiumFare();
	remainingSeats= flight.getStatus().getRemainingPremiumSeats();

	}

	if(!fare.equals(passenger.getPayment().getAmount())) {

	throw new PaymentFailedException();
	}

	if(remainingSeats<1) {

	throw new NoSeatsAvailableException();
	}


	passenger.setBookingDate(date);
	passenger.setPayment(paymentDao.save(passenger.getPayment()));
	Integer i= flight.getBooking().getBookingId();
	Booking booking= flight.getBooking();
	booking.setTotalCost(booking.getTotalCost()+ fare);
	booking.setBookingNumber((long)((flight.getId()+booking.getBookingId())*100));
	booking.setBookingId(i);
	booking.setTotalCost(booking.getTotalCost()+ fare);
	booking.setTravelDate(flight.getDepartureTime());
	bookingDao.save(booking);

	passenger.setBooking(booking);
	passengerDao.save(passenger);

	flight.setBooking(booking);
	flightDao.save(flight);


	return true;
	}

	@Override
	public Boolean cancelTicket(String userName, String password, Integer flightId, String firstName, String lastName) {
		
		Optional<Passenger> p1= passengerDao.findByFirstName(firstName);
		Optional<Passenger> p2= passengerDao.findByLastName(lastName);
		
		if(p1.isEmpty() || p2.isEmpty()) {
			throw new UserNotFoundException();
			
		}else if(p1.map(Passenger:: getFirstName).orElse("").equals(p2.map(Passenger:: getFirstName).orElse("")) && 
				p1.map(Passenger:: getLastName).orElse("").equals(p2.map(Passenger:: getLastName).orElse("")) && 
				p1.map(Passenger:: getPassportNo).orElse("").equals(p2.map(Passenger:: getPassportNo).orElse(""))) { 
			
			User user= userDao.findByUserName(userName).orElseThrow(UserNotFoundException:: new);
			
			if(!password.equals(user.getPassword())) {
			
				throw new PasswordNotMatchedException();
			}
		
			Flight flight1= flightDao.findById(flightId).orElseThrow(FlightNotFoundException:: new);
			
			Payment pay= p1.map(Passenger:: getPayment).orElseThrow(DataNotCorrectException:: new);
			int j= pay.getId();
			
			Booking booking= bookingDao.findById(flight1.getBooking().getBookingId()).orElseThrow(DataNotCorrectException:: new);
			flightDao.deleteById(flightId);
			booking.setTotalCost(booking.getTotalCost()- p1.map(Passenger:: getPayment).orElseThrow(DataNotCorrectException:: new).getAmount());
			bookingDao.deleteById(booking.getBookingId());
			passengerDao.deleteById(p1.map(Passenger:: getPassengerId).orElse(0));
			paymentDao.deleteById(j);
			flight1.setBooking(bookingDao.save(booking));
			flightDao.save(flight1);
			FlightStatus status= flight1.getStatus();
		
			if(p1.map(Passenger:: getFlightType).orElse("").equals("Premium")) {
		
				status.setRemainingPremiumSeats(status.getRemainingPremiumSeats()+ 1);
			}else if(p1.map(Passenger:: getFlightType).orElse("").equals("Business")) {
			
				status.setRemainingPremiumSeats(status.getRemainingBusinessSeats()+ 1);
			}else if(p1.map(Passenger:: getFlightType).orElse("").equals("Economy")) {
			
				status.setRemainingPremiumSeats(status.getRemainingEconomySeats()+ 1);
			}
		
			flightStatusDao.save(status);
		}
		
		return true;
	}

	@Override
	public void deleteBooking(Booking booking) {
		
		Optional<Booking> optional= bookingDao.findById(booking.getBookingId());
		
		if(optional.isEmpty()) {
			
			throw new BookingNotCorrectException();
		}
		
		
		Set<Passenger> passengers= passengerDao.findAllByBooking(booking); 
		
		for(Passenger p: passengers) {
			
			paymentDao.deleteById(p.getPayment().getId());
			passengerDao.deleteById(p.getPassengerId());
		}
	
		bookingDao.deleteById(booking.getBookingId());
	}

	@Override
	public Booking initializeBooking(Booking booking) {

		if(booking!= null) {
			
			return bookingDao.save(booking);
		}
		
		throw new DataNotCorrectException();
	}

}
