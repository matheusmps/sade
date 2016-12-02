package com.mc437.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mc437.interceptor.LoggedUserHelper;
import com.mc437.model.Developer;
import com.mc437.model.User;
import com.mc437.model.UserType;
import com.mc437.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	LoggedUserHelper loggedUserHelper;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model){
		return "index";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String devRegister(ModelMap model){
		Developer dev = new Developer();
		model.addAttribute("developer", dev);
		return "devRegister";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String saveUser(@Valid Developer developer, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "devRegister";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!userService.isUsernameUnique(developer.getId(), developer.getUsername())){
			FieldError usernameError = new FieldError("user","username", messageSource.getMessage("non.unique.username", new String[]{developer.getUsername()}, Locale.getDefault()));
		    result.addError(usernameError);
			return "devRegister";
		}
		
		userService.saveUser(developer);

		return "redirect:/login?registerSuccess";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(ModelMap model){
		if (loggedUserHelper.isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	if(loggedUserHelper.getCurrentUserType().equals(UserType.DEVELOPER))
	    		return "redirect:/dev";
	    	else
	    		return "redirect:/member/";
	    }
	}
	
	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		return "redirect:/login?logout";
	}
	
	@RequestMapping(value = "Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		return "accessDenied";
	}

}
