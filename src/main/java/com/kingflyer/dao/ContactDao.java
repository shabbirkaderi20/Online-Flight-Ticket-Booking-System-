package com.kingflyer.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kingflyer.model.Contact;

public interface ContactDao extends CrudRepository<Contact, Integer>{

	public Optional<Contact> findByMobileNo(Long mobileNo);
	
}
