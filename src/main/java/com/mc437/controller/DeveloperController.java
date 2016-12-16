package com.mc437.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mc437.interceptor.LoggedUserHelper;
import com.mc437.model.Developer;
import com.mc437.service.DeveloperServiceImpl;

@Controller
@RequestMapping("dev")
@SessionAttributes("roles")
public class DeveloperController {
	
	@Autowired
	LoggedUserHelper loggedUserHelper;
	
	@Autowired
	DeveloperServiceImpl developerService;

	@RequestMapping(method = RequestMethod.GET)
	public String dev(ModelMap map){
		Developer developer = (Developer) loggedUserHelper.getCurrentUser();
		map.addAttribute("dev", developer);
		return "developer/manager-dev";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveDeveloper(@ModelAttribute("dev") @Valid Developer dev, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "developer/manager-dev";
		}

		developerService.updateDeveloper(dev);		
		return "developer/manager-dev";
	}
	
}
