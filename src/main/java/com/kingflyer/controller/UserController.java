package com.kingflyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kingflyer.constant.Constant;
import com.kingflyer.dto.UserDto;
import com.kingflyer.dto.UserLogin;
import com.kingflyer.exception.DataNotCorrectException;
import com.kingflyer.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	@CrossOrigin
	@PostMapping(value="/userLogin",consumes="application/json")
	public String userLogin(@RequestBody UserLogin userLogin) {
		
		boolean isUserAdded = userService.loginUser(userLogin.tempUserName, userLogin.tempPassword);
		if(isUserAdded) {
			return Constant.LOGIN_SUCCESSFULL;
		}
		
		throw new DataNotCorrectException();
	}
	@CrossOrigin
	@PostMapping(value="/registerUser",consumes="application/json")
	public String addUser(@RequestBody UserDto userDto) {
		
		boolean isUserAdded = userService.addUser(userDto);
		
		if(isUserAdded) {
			return Constant.ADDITION_SUCCESSFULL;
		}
		
		throw new DataNotCorrectException();
	}
	@CrossOrigin
	@PostMapping(value="/updateUser", consumes="application/json")
	public String updateUser(@RequestBody UserDto userDto){
		
		boolean isUserUpdate= userService.modifyUser(userDto);
		
		if(isUserUpdate) {
			return Constant.UPDATE_SUCCESSFULL;
		}
		throw new DataNotCorrectException();
	}
	@CrossOrigin
	@PostMapping(value="/deleteUser",consumes="application/json")
	public String deleteUser(@RequestBody UserLogin userLogin){
		
		boolean isUserUpdate= userService.deleteUser(userLogin.tempUserName, userLogin.tempPassword);
		
		if(isUserUpdate) {
			return Constant.DELETION_SUCCESSFULL;
		}
		throw new DataNotCorrectException();
	}
	
}
