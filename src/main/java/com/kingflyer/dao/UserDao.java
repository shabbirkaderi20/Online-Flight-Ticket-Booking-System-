package com.kingflyer.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kingflyer.model.User;

public interface UserDao extends CrudRepository<User,Integer>{

	public Optional<User> findByUserName(String userName);
	public Optional<User> findByEmail(String email);

}
