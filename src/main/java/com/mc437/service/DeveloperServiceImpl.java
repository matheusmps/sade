package com.mc437.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc437.dao.DeveloperDao;
import com.mc437.dao.UserDao;
import com.mc437.model.Developer;
import com.mc437.model.User;
import com.mc437.model.UserType;

@Service("developerService")
@Transactional
public class DeveloperServiceImpl implements DeveloperService{
	
	@Autowired
	UserService userService;
	
	@Autowired
	private DeveloperDao dao;
	
	public List<Developer> getAll(){
		List<User> users = userService.findByUserType(UserType.DEVELOPER);
		List<Developer> devs = new ArrayList<>();
		for(User user : users){
			devs.add((Developer) user);
		}
		return devs;
	}
	
	public void updateDeveloper(Developer developer) {
		Developer entity = dao.findById(developer.getId());
		if(entity!=null){
			entity.setAddress(developer.getAddress());
			entity.setAvailableHours(developer.getAvailableHours());
			entity.setCellphoneNumber(developer.getCellphoneNumber());
			entity.setCourse(developer.getCourse());
			entity.setCourseHours(developer.getCourseHours());
			entity.setCourseStartYear(developer.getCourseStartYear());
			entity.setEducationInstitution(developer.getEducationInstitution());
			entity.setEmail(developer.getEmail());
			entity.setInternshipHours(developer.getInternshipHours());
			entity.setPhoneNumber(developer.getPhoneNumber());
			entity.setSkillGrades(developer.getSkillGrades());
		}
	}

	@Override
	public Developer findById(int id) {
		return dao.findById(id);
	}
	

}
