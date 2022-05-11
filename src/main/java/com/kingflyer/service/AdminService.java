package com.kingflyer.service;

import com.kingflyer.dto.AdminDto;

public interface AdminService {
	
	public Boolean loginAdmin(String userName, String password);
	public Boolean addAdmin(AdminDto adminDto);
	public Boolean updateAdmin(AdminDto adminDto);
	public Boolean deleteAdmin(String userName, String password);
}
