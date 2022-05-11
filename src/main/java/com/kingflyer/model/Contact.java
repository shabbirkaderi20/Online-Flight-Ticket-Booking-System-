package com.kingflyer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Contact {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer contactId;
	
	@OneToOne(mappedBy= "contact")
	private User user;
	
	private String type;
	private String addressLine;
	private Long zipCode; 
	private String city;
	private String state;
	private String country;

	
	@Column(unique = true)
	private Long mobileNo;
	
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer id) {
		this.contactId = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
}
