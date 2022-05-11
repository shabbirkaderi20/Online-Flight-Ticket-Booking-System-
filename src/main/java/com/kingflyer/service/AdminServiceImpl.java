package com.kingflyer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingflyer.dao.AdminDao;
import com.kingflyer.dto.AdminDto;
import com.kingflyer.exception.AdminAlreadyExistsException;
import com.kingflyer.exception.AdminNotFoundException;
import com.kingflyer.exception.PasswordNotMatchedException;
import com.kingflyer.helper.AdminDtoToModel;
import com.kingflyer.model.Admin;

@Component
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	AdminDtoToModel adminDtoToModel; 
	
	@Override
	public Boolean loginAdmin(String userName, String password) {
		
		Optional<Admin> optional= adminDao.findByUserName(userName);
		
		if(optional.isPresent() && optional.map(Admin:: getAdminPassword).orElse(password).equals(password)) {
			
			return true;
		}
		
		throw new AdminNotFoundException();
	}
	
	@Override
	public Boolean addAdmin(AdminDto adminDto) {
		
		Admin admin= adminDtoToModel.convertAdminDtoToModel(adminDto);
		
		Optional<Admin> optional= adminDao.findByAdminLastName(admin.getAdminLastName());
		Optional<Admin> optional1= adminDao.findByUserName(admin.getUserName());
		Optional<Admin> optional2= adminDao.findByAdminFirstName(admin.getAdminFirstName());
		
		if(optional1.isPresent()) {
			if(optional.map(Admin:: getAdminFirstName).orElse(admin.getAdminFirstName()).equals(optional2.map(Admin:: getAdminFirstName).orElse(admin.getAdminFirstName())) && optional.map(Admin:: getAdminLastName).orElse(admin.getAdminLastName()).equals(optional2.map(Admin:: getAdminLastName).orElse(admin.getAdminLastName()))) {
			
				throw new AdminAlreadyExistsException(); 
			}
			
			throw new AdminAlreadyExistsException();
		}

		
		admin.setAdminId(null);
		adminDao.save(admin);
		
		return true;
	}
	
	@Override
	public Boolean updateAdmin(AdminDto adminDto) {
		
		Admin admin= adminDtoToModel.convertAdminDtoToModel(adminDto);
		
		Optional<Admin> optional1= adminDao.findByUserName(admin.getUserName());
		
		if(optional1.isPresent()) {
			if(optional1.map(Admin:: getAdminPassword).orElse(admin.getAdminPassword()).equals(admin.getAdminPassword())) {
				
				adminDao.save(admin);
				
				return true; 
			}
			
			throw new PasswordNotMatchedException();
		}
		
		throw new AdminNotFoundException();
	}
	
	@Override
	public Boolean deleteAdmin(String userName, String password) {
		
		Admin admin= adminDao.findByUserName(userName).orElseThrow(AdminNotFoundException:: new);
		
				
		if(!admin.getAdminPassword().equals(password)) {
			throw new PasswordNotMatchedException();
		}
		
		adminDao.deleteById(admin.getAdminId());
				
		return true; 

	}

}
