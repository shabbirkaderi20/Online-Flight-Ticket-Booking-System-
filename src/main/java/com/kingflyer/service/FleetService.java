package com.kingflyer.service;

import com.kingflyer.model.Fleet;

public interface FleetService {

	public Fleet addFleet(Fleet fleet);
	public Fleet modifyFleet(Fleet fleet);
	public Boolean deleteFleet(Fleet fleet);
}
