package com.kingflyer.service;

import com.kingflyer.dto.UserDto;

public interface UserService {
	
	public Boolean loginUser(String userName, String password);
	public Boolean addUser(UserDto userDto);
	public Boolean modifyUser(UserDto userDto);
	public Boolean deleteUser(String userName, String password);
	
}
