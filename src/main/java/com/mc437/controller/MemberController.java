package com.mc437.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("member")
@SessionAttributes("roles")
public class MemberController {

	@RequestMapping(method = RequestMethod.GET)
	public String dev(){
		return "manager-member";
	}
}
