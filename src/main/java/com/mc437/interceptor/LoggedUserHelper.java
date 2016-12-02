package com.mc437.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.mc437.model.User;
import com.mc437.model.UserType;
import com.mc437.service.UserService;

@Component
public class LoggedUserHelper {

	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	public User getCurrentUser(){
		if(getCurrentUsername() != null)
			return userService.findByUsername(getCurrentUsername());
		return null;
	}
	
	public UserType getCurrentUserType(){
		User currentUser = getCurrentUser();
		if(currentUser != null)
			return UserType.getUserType(currentUser);
		else
			return null;
	}
	
	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getCurrentUsername(){
		String userName = null;
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null) 
			return null;

		Object principal = authentication.getPrincipal();
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else if(principal != null){
			userName = principal.toString();
		}else{
			return null;
		}
		
		return userName;
	}
	
	/**
	 * This method returns true if users is not authenticated [logged-in], else false.
	 */
	public boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}

	
}
