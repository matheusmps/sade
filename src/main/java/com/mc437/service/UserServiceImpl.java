package com.mc437.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc437.dao.UserDao;
import com.mc437.model.User;
import com.mc437.model.UserType;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByUsername(String sso) {
		User user = dao.findByUsername(sso);
		return user;
	}
	
	public List<User> findByUserType(UserType type){
		if(type == null)
			throw new RuntimeException("null type");
		List<Integer> ids = dao.findByUserType(type);
		List<User> users = new ArrayList<User>();
		for(Integer id : ids)
			users.add(dao.findById(id));
		
		return users;
	}

	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
		}
	}

	
	public void deleteUserByUsername(String username) {
		dao.deleteByUsername(username);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUsernameUnique(Integer id, String username) {
		User user = findByUsername(username);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
