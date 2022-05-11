package com.kingflyer.helper;

import org.springframework.stereotype.Component;

import com.kingflyer.dto.AdminDto;
import com.kingflyer.model.Admin;

@Component
public class AdminDtoToModel {
	
	public Admin convertAdminDtoToModel(AdminDto adminDto) {
		
		Admin admin= new Admin();
		
		admin.setAdminId(adminDto.getAdminId());
		admin.setAdminFirstName(adminDto.getAdminFirstName());
		admin.setAdminLastName(adminDto.getAdminLastName());
		admin.setUserName(adminDto.getUserName());
		admin.setAdminPassword(adminDto.getAdminPassword());
		
		return admin;
	}
}
