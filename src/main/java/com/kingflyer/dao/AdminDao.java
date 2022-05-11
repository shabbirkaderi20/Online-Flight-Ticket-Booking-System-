package com.kingflyer.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kingflyer.model.Admin;

public interface AdminDao extends CrudRepository<Admin, Integer>{
	
	public Optional<Admin> findByUserName(String userName);

	public Optional<Admin> findByAdminFirstName(String adminFirstName);

	public Optional<Admin> findByAdminLastName(String adminLastName);

}
