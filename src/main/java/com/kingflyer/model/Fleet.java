package com.kingflyer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Fleet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "fleet_id")
	private Integer fleetId;
	
	@OneToOne(mappedBy= "fleet")
	private Flight flight;
	
	@Column(unique = true)
	private String code;
	
	private String model;
	private Integer totalEconomySeats;
	private Integer totalPremiumSeats;
	private Integer totalBusinessSeats;
	
	public Integer getId() {
		return fleetId;
	}
	public void setId(Integer id) {
		this.fleetId = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getTotalEconomySeats() {
		return totalEconomySeats;
	}
	public void setTotalEconomySeats(Integer totalEconomySeats) {
		this.totalEconomySeats = totalEconomySeats;
	}
	public Integer getTotalPremiumSeats() {
		return totalPremiumSeats;
	}
	public void setTotalPremiumSeats(Integer totalPremiumSeats) {
		this.totalPremiumSeats = totalPremiumSeats;
	}
	public Integer getTotalBusinessSeats() {
		return totalBusinessSeats;
	}
	public void setTotalBusinessSeats(Integer totalBusinessSeats) {
		this.totalBusinessSeats = totalBusinessSeats;
	}
	
	
}
