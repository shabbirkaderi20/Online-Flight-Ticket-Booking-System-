package com.kingflyer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingflyer.dao.FleetDao;
import com.kingflyer.exception.FleetNotCorrectException;
import com.kingflyer.model.Fleet;

@Component
public class FleetServiceImpl implements FleetService {

	@Autowired
	FleetDao fleetDao;
	
	@Override
	public Fleet addFleet(Fleet fleet) {
		
		if(fleet==null) {
			throw new FleetNotCorrectException();
		}
		return fleetDao.save(fleet);
	}

	@Override
	public Fleet modifyFleet(Fleet fleet) {
		
		Optional<Fleet> optional= fleetDao.findById(fleet.getId());
		
		if(optional.isEmpty()) {
			throw new FleetNotCorrectException();
		}
		return fleetDao.save(fleet);
	}

	@Override
	public Boolean deleteFleet(Fleet fleet) {
		Optional<Fleet> optional= fleetDao.findById(fleet.getId());
		
		if(optional.isEmpty()) {
			
			throw new FleetNotCorrectException();
		}
		
		fleetDao.deleteById(fleet.getId());
		
		return true;
	}

}
