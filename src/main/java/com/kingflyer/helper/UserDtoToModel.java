package com.kingflyer.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingflyer.dao.ContactDao;
import com.kingflyer.dto.UserDto;
import com.kingflyer.model.User;


@Component
public class UserDtoToModel {
	
	@Autowired
	ContactDao contactDao;
	
	public User convertUserDtoToModel(UserDto userDto) {
		
		User user= new User();
		
		user.setUserId(userDto.getUserId());
		user.setUserName(userDto.getUserName());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setContact(userDto.getContact());
		
		return user;
	}
}
