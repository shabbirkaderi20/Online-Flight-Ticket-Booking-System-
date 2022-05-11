package com.kingflyer.service;

import com.kingflyer.model.Contact;

public interface ContactService {
	
	public Contact addContact(Contact contact);
	public void deleteContact(Contact contact);
	public Contact updateContact(Contact contact);
}
