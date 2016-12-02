package com.mc437.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc437.model.Developer;
import com.mc437.model.User;
import com.mc437.model.UserType;

@Service("developerService")
@Transactional
public class DeveloperServiceImpl {
	
	@Autowired
	UserService userService;
	
	public List<Developer> getAll(){
		List<User> users = userService.findByUserType(UserType.DEVELOPER);
		List<Developer> devs = new ArrayList<>();
		for(User user : users){
			devs.add((Developer) user);
		}
		return devs;
	}
	
	

}
