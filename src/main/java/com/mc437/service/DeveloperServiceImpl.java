package com.mc437.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc437.dao.DeveloperDao;
import com.mc437.model.Developer;
import com.mc437.model.User;
import com.mc437.model.UserType;

@Service("developerService")
@Transactional
public class DeveloperServiceImpl{
	
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
	
	public void updateDeveloper(Developer developer) {
		Developer entity = findById(developer.getId());
		
		if(entity != null){
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

	public Developer findById(int id) {
		User user = userService.findById(id);
		if(user !=null && user instanceof Developer){
			return (Developer) user;
		}else{
			return null;
		}
	}
	

}
