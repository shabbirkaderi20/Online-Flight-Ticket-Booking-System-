package com.kingflyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kingflyer.constant.Constant;
import com.kingflyer.dto.AdminDto;
import com.kingflyer.dto.AdminLogin;
import com.kingflyer.exception.DataNotCorrectException;
import com.kingflyer.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	@CrossOrigin
	@PostMapping(value="/adminLogin",consumes="application/json")
	public String adminLogin(@RequestBody AdminLogin adminLogin) {
		String userName=adminLogin.userName;
		String password=adminLogin.password;
		boolean isUserAdded = adminService.loginAdmin(userName,password);
		
		if(isUserAdded) {
			return Constant.LOGIN_SUCCESSFULL;
		}
		
		throw new DataNotCorrectException();
	}
	@CrossOrigin
	@PostMapping(value="/registerAdmin",consumes="application/json")
	public String addAdmin(@RequestBody AdminDto adminDto) {
		
		boolean isUserAdded = adminService.addAdmin(adminDto);
		
		if(isUserAdded) {
			return Constant.ADDITION_SUCCESSFULL;
		}
		
		throw new DataNotCorrectException();
	}
	@CrossOrigin
	@PostMapping(value="/updateAdmin",consumes="application/json")
	public String updateAdmin(@RequestBody AdminDto adminDto){
		
		boolean isUserUpdate= adminService.updateAdmin(adminDto);
		
		if(isUserUpdate) {
			return Constant.UPDATE_SUCCESSFULL;
		}
		throw new DataNotCorrectException();
	}
	@CrossOrigin
	@PostMapping(value="/deleteAdmin",consumes="application/json")
	public String deleteAdmin(@RequestBody AdminLogin adminLogin){
		
		boolean isUserUpdate= adminService.deleteAdmin(adminLogin.userName, adminLogin.password);
		
		if(isUserUpdate) {
			return Constant.DELETION_SUCCESSFULL;
		}
		throw new DataNotCorrectException();
	}
}
