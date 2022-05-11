package com.kingflyer.dao;

import org.springframework.data.repository.CrudRepository;

import com.kingflyer.model.Location;

public interface LocationDao extends CrudRepository<Location, Integer> {

}
