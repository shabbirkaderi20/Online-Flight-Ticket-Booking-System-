package com.kingflyer.dao;

import org.springframework.data.repository.CrudRepository;

import com.kingflyer.model.Payment;

public interface PaymentDao extends CrudRepository<Payment, Integer>{

}
