package com.kingflyer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Fare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Double economyFare;
	private Double premiumFare;
	private Double businessFare;
	
	@OneToOne(mappedBy= "fare")
	private Flight flight;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getEconomyFare() {
		return economyFare;
	}
	public void setEconomyFare(Double economyFare) {
		this.economyFare = economyFare;
	}
	public Double getPremiumFare() {
		return premiumFare;
	}
	public void setPremiumFare(Double premiumFare) {
		this.premiumFare = premiumFare;
	}
	public Double getBusinessFare() {
		return businessFare;
	}
	public void setBusinessFare(Double businessFare) {
		this.businessFare = businessFare;
	}
	
	
}

