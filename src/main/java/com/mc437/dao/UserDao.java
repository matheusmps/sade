package com.mc437.dao;

import java.util.List;

import com.mc437.model.User;


public interface UserDao {

	User findById(int id);
	
	User findByUsername(String username);
	
	void save(User user);
	
	void deleteByUsername(String username);
	
	List<User> findAllUsers();

}

