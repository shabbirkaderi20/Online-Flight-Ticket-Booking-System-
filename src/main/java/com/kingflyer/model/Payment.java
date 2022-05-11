package com.kingflyer.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	
	@Id
	@Column(name= "payment_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int paymentId;
	
	private Double amount;
	
	@OneToOne(mappedBy= "payment", cascade = CascadeType.ALL)
	private Passenger passenger;
	
	public int getId() {
		return paymentId;
	}
	public void setId(int id) {
		this.paymentId = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
