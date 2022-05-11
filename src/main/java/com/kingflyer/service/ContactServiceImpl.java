package com.kingflyer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingflyer.dao.ContactDao;
import com.kingflyer.exception.DataNotCorrectException;
import com.kingflyer.exception.UserAlreadyExistsException;
import com.kingflyer.exception.UserNotFoundException;
import com.kingflyer.model.Contact;

@Component
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	ContactDao contactdao;
	
	@Override
	public Contact addContact(Contact contact) {
		
		Optional<Contact> optional= contactdao.findByMobileNo(contact.getMobileNo());
		
		if(optional.isPresent()) {
			throw new UserAlreadyExistsException();
		}
		if(contact.getType()== null || contact.getAddressLine()== null || contact.getCity()== null ||
				contact.getCountry()== null || contact.getState()== null || contact.getMobileNo()< 7500000000l || contact.getZipCode()< 100000) {
			
			throw new DataNotCorrectException();
		}
		
		contact.setContactId(null);
		contactdao.save(contact);
		
		return contact;
	}

	@Override
	public void deleteContact(Contact contact) {
		
		contactdao.deleteById(contact.getContactId());
	}

	@Override
	public Contact updateContact(Contact contact) {
		
		Optional<Contact> optional= contactdao.findByMobileNo(contact.getMobileNo());
		
		if(optional.isEmpty()) {
			if(contact.getType()== null || contact.getAddressLine()== null || contact.getCity()== null ||
				contact.getCountry()== null || contact.getState()== null || contact.getMobileNo()< 7500000000l || contact.getZipCode()< 100000) {
			
				throw new DataNotCorrectException();
			}
			
			throw new UserNotFoundException();
		}
		
		contactdao.save(contact);
		
		return contact;
	}
	
	

}
