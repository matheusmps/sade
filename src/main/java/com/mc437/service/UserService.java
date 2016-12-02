package com.mc437.service;

import java.util.List;

import com.mc437.model.User;


public interface UserService {
	
	User findById(int id);
	
	User findByUsername(String sso);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByUsername(String sso);

	List<User> findAllUsers(); 
	
	boolean isUsernameUnique(Integer id, String sso);

}