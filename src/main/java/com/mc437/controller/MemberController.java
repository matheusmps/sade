package com.mc437.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mc437.model.Developer;
import com.mc437.model.User;
import com.mc437.service.DeveloperServiceImpl;
import com.mc437.service.UserService;

@Controller
@RequestMapping("member")
@SessionAttributes("roles")
public class MemberController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DeveloperServiceImpl developerService;

	@RequestMapping(method = RequestMethod.GET, value={"", "/", "perfil"})
	public String perfil(){
		return "member/manager-member";
	}
	
	@RequestMapping(method = RequestMethod.POST, value={"", "/", "perfil"})
	public String savePerfil(@Valid User user, BindingResult result, ModelMap model){
		if(result.hasErrors())
			return "member/manager-member";
		
		userService.updateUser(user);
		return perfil();
	}
	
	@RequestMapping(value = "list-dev", method = RequestMethod.GET)
	public String listDev(ModelMap model){
		model.addAttribute("devs", developerService.getAll());
		return "member/member-list-dev";
	}
	
	@RequestMapping(value = "dev/{id}")
	public String editDev(@PathVariable(value="id") String id, ModelMap model){
		Developer dev = developerService.findById(Integer.parseInt(id));
		model.addAttribute("dev", dev);
		return "member/member-dev";
	}
	
	@RequestMapping(value = "dev/{id}", method = RequestMethod.POST)
	public String saveDev(@ModelAttribute("dev") @Valid Developer dev, BindingResult result, @PathVariable(value="id") String id, ModelMap model){
		if (result.hasErrors()) {
			return "member/member-dev";
		}

		developerService.updateDeveloper(dev);		
		return "member/member-dev";
	}
	
	
}
