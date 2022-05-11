package com.kingflyer.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.kingflyer.model.Location;

@Component
public class LocationServiceImpl implements LocationService {


	@Override
	public Set<Location> addLocation(Set<Location> location) {
		
		int i= 0;
		Set<Location> set= new HashSet<>();
		
		for(Location l: location) {
			if(i<3) {
				set.add(l);
			}else {
				break;
			}
			i++;
			
		}
		
		return set;
	}

}
