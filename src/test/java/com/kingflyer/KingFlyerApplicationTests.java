package com.kingflyer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kingflyer.dao.AdminDao;
import com.kingflyer.dao.ContactDao;
import com.kingflyer.dao.FareDao;
import com.kingflyer.dao.FlightDao;
import com.kingflyer.dao.UserDao;
import com.kingflyer.model.Admin;
import com.kingflyer.model.Fare;
import com.kingflyer.model.Flight;
import com.kingflyer.model.User;

@SpringBootTest
class KingFlyerApplicationTests {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	FlightDao flightDao;
	
	@Autowired
	ContactDao contactDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	FareDao fareDao;
	
	@Test
	void adminTestCase() {
		
		Admin admin = new Admin();
		
		admin.setAdminId(3);
		admin.setAdminFirstName("Bharath");
		admin.setAdminLastName("Gowda");
		admin.setUserName("bharath10");
		admin.setAdminPassword("bharath147");
		assertNotNull(adminDao.findById(3).get());
	}

	@Test
	void searchFlightsTestCase() {
		assertNotNull((List<Flight>) flightDao.findAll());
	}
	
	@Test
	void userTestCase() {
		
		User user= new User();
		
		user.setUserId(2);
		user.setUserName("shabbir20");
		user.setFirstName("Shabbir");
		user.setLastName("Kaderi");
		user.setEmail("sjk@gmail.com");
		user.setPassword("shabbir123");
		user.setContact(contactDao.findById(1).get());
		assertNotNull(userDao.findById(2).get());
	}
	
	@Test
	void searchFlightsByLocationTestCase() {
		assertNotNull(flightDao.findAllByArrivalLocation("Delhi"));
		assertNotNull(flightDao.findAllByDepartureLocation("Pune"));
	}
	
	@Test
	void fareTestCase() {
		
		Fare fare= new Fare();
		
		fare.setBusinessFare(150d);
		fare.setEconomyFare(100d);
		fare.setPremiumFare(200d);
		fare.setId(6);
		assertNotNull(fareDao.findById(6));
	}
	
}
