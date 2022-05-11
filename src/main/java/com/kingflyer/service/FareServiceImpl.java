package com.kingflyer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingflyer.dao.FareDao;
import com.kingflyer.exception.FareNotCorrectException;
import com.kingflyer.model.Fare;

@Component
public class FareServiceImpl implements FareService {
	
	@Autowired
	FareDao fareDao;
	
	@Override
	public Fare addFare(Fare fare) {
		
		if(fare== null) {
			throw new FareNotCorrectException();
		}
		return fareDao.save(fare);
	}

	@Override
	public Fare modifyFare(Fare fare) {
		
		Optional<Fare> optional= fareDao.findById(fare.getId());
		
		if(optional.isEmpty()) {
			throw new FareNotCorrectException();
		}
		
		return fareDao.save(fare);
	}

	@Override
	public Boolean deleteFare(Fare fare) {

		Optional<Fare> optional= fareDao.findById(fare.getId());
		
		if(optional.isEmpty()) {
			throw new FareNotCorrectException();
		}
		
		fareDao.deleteById(fare.getId());
		
		return true;
	}
	
	
}
