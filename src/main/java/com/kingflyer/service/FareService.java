package com.kingflyer.service;

import com.kingflyer.model.Fare;

public interface FareService {

	public Fare addFare(Fare fare);

	public Fare modifyFare(Fare fare);

	public Boolean deleteFare(Fare fare);
}
