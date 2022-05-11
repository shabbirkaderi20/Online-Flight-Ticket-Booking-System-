package com.kingflyer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingflyer.dao.BookingDao;
import com.kingflyer.dao.ContactDao;
import com.kingflyer.dao.FareDao;
import com.kingflyer.dao.FlightDao;
import com.kingflyer.dao.FlightStatusDao;
import com.kingflyer.dao.PassengerDao;
import com.kingflyer.dao.PaymentDao;
import com.kingflyer.dao.UserDao;
import com.kingflyer.dto.UserDto;
import com.kingflyer.exception.DataNotCorrectException;
import com.kingflyer.exception.PasswordNotMatchedException;
import com.kingflyer.exception.UserAlreadyExistsException;
import com.kingflyer.exception.UserNotExistsException;
import com.kingflyer.exception.UserNotFoundException;
import com.kingflyer.helper.UserDtoToModel;
import com.kingflyer.model.Contact;
import com.kingflyer.model.User;


@Service
public class UserServiceImpl implements UserService {

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
	UserDtoToModel userDtoToModel;
	
	@Override
	public Boolean loginUser(String userName, String password) {
		
		User user= userDao.findByUserName(userName).orElseThrow(UserNotExistsException:: new);
		
		if(password.equals(user.getPassword())) {
		
			return true;
		}
		
		throw new PasswordNotMatchedException();
	}
	
	
	@Override
	public Boolean addUser(UserDto userDto) {
		
		User user= userDtoToModel.convertUserDtoToModel(userDto);
		
		Optional<User> optional= userDao.findByUserName(user.getUserName());
		Optional<User> optional1= userDao.findByEmail(user.getEmail());
		
		
		if(optional.isPresent() || optional1.isPresent()) {
			throw new UserAlreadyExistsException();
		}
		
		if(user.getFirstName()!= null || user.getLastName()!= null || user.getEmail()!= null ||
				user.getPassword()!= null || user.getUserName()!= null) {
				
			contactData.addContact(user.getContact());
			Contact contact1= contactDao.findByMobileNo(user.getContact().getMobileNo()).orElseThrow(UserNotFoundException:: new);
			
			user.setUserId(null);
			
			user.setContact(contact1);
			userDao.save(user);
			
			return true;
		}else {
			throw new DataNotCorrectException();
		}
		
	}

	@Override
	public Boolean modifyUser(UserDto userDto) {
		
		User user= userDtoToModel.convertUserDtoToModel(userDto);
		
		Optional<User> optional= userDao.findByUserName(user.getUserName());
		
		if(optional.isPresent()) {
			
			Contact contactObj= contactData.updateContact(user.getContact());
			user.setContact(contactObj);
			userDao.save(user);
			
			return true;
		}
		throw new UserNotFoundException();
		
	}

	@Override
	public Boolean deleteUser(String userName, String password) {
		
		Optional<User> optional= userDao.findByUserName(userName);
		
		if(optional.isEmpty()) {
			
			throw new UserNotFoundException();
		}
		if(!password.equals(optional.map(User:: getPassword).orElse(password))) {
			
			throw new PasswordNotMatchedException();
		}
		
		contactData.deleteContact(optional.map(User:: getContact).orElseThrow(DataNotCorrectException:: new));
		userDao.deleteById(optional.map(User:: getUserId).orElseThrow(DataNotCorrectException:: new));
		
		return true;
	}

}
