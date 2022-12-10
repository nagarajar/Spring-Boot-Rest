package com.app.service;

import com.app.entity.User;

public interface UserService 
{
	String saveUser(User user);
	User getOneUser(Integer id);
	String updateUser(Integer id, User user);
	String deleteUser(Integer id);
	
}
