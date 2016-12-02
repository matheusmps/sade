package com.mc437.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("dev")
@SessionAttributes("roles")
public class DeveloperController {

	@RequestMapping(method = RequestMethod.GET)
	public String dev(){
		return "manager-dev";
	}
}
