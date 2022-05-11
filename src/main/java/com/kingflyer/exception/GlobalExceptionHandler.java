package com.kingflyer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kingflyer.constant.Constant;


@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(DataNotCorrectException.class)
	public ResponseEntity<Object> handleDataNotCorrectException(DataNotCorrectException exception) {
		return new ResponseEntity<>(Constant.DATA_NOT_CORRECT, HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
		return new ResponseEntity<>(Constant.USER_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
		return new ResponseEntity<>(Constant.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotExistsException.class)
	public ResponseEntity<Object> handleUserNotExistsException(UserNotExistsException exception) {
		return new ResponseEntity<>(Constant.USER_NOT_EXISTS, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoFlightsFoundException.class)
	public ResponseEntity<Object> handleNoFlightsFoundException(NoFlightsFoundException exception) {
		return new ResponseEntity<>(Constant.NO_FLIGHTS_FOUND, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentFailedException.class)
	public ResponseEntity<Object> handlePaymentFailedException(PaymentFailedException exception) {
		return new ResponseEntity<>(Constant.PAYMENT_FAILED, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(NoSeatsAvailableException.class)
	public ResponseEntity<Object> handleNoSeatsAvailableException(NoSeatsAvailableException exception) {
		return new ResponseEntity<>(Constant.NO_SEATS_AVAILABLE, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<Object> handleFlightNotFoundException(FlightNotFoundException exception) {
		return new ResponseEntity<>(Constant.FLIGHT_NOT_EXISTS, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PasswordNotMatchedException.class)
	public ResponseEntity<Object> handlePasswordNotMatchedException(PasswordNotMatchedException exception) {
		return new ResponseEntity<>(Constant.PASSWORD_NOT_CORRECT, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(NoFlightsCurrentlyException.class)
	public ResponseEntity<Object> handleNoFlightsCurrentlyException(NoFlightsCurrentlyException exception) {
		return new ResponseEntity<>(Constant.NO_FLIGHT_CURRENTLY, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AdminAlreadyExistsException.class)
	public ResponseEntity<Object> handleAdminAlreadyExistsException(AdminAlreadyExistsException exception) {
		return new ResponseEntity<>(Constant.ADMIN_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<Object> handleAdminNotFoundException(AdminNotFoundException exception) {
		return new ResponseEntity<>(Constant.ADMIN_NOT_EXISTS, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FlightAlreadyExistsException.class)
	public ResponseEntity<Object> handleFlightAlreadyExistsException(FlightAlreadyExistsException exception) {
		return new ResponseEntity<>(Constant.FLIGHT_ALREADY_EXISTS, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StatusNotCorrectException.class)
	public ResponseEntity<Object> handleStatusNotCorrectException(StatusNotCorrectException exception) {
		return new ResponseEntity<>(Constant.FLIGHT_STATUS_INCORRECT, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FareNotCorrectException.class)
	public ResponseEntity<Object> handleFareNotCorrectException(FareNotCorrectException exception) {
		return new ResponseEntity<>(Constant.FLIGHT_FARE_INCORRECT, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FleetNotCorrectException.class)
	public ResponseEntity<Object> handleFleetNotCorrectException(FleetNotCorrectException exception) {
		return new ResponseEntity<>(Constant.FLIGHT_FLEET_INCORRECT, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookingNotCorrectException.class)
	public ResponseEntity<Object> handleBookingNotCorrectException(BookingNotCorrectException exception) {
		return new ResponseEntity<>(Constant.FLIGHT_BOOKING_INCORRECT, HttpStatus.BAD_REQUEST);
	}
}
