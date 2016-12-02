package com.mc437.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.mc437.interceptor.LoggedUserHelper;
import com.mc437.model.UserType;

@Component
public class MySimpleUrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	@Autowired
	LoggedUserHelper loggedUserHelper;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted())
			return;
		
		redirectStrategy.sendRedirect(request, response, targetUrl);
		super.handle(request, response, authentication);
	}
	
	protected String determineTargetUrl(Authentication authentication) {
		if(loggedUserHelper.getCurrentUserType().equals(UserType.DEVELOPER)){
			return "/dev";
		}else if(loggedUserHelper.getCurrentUserType().equals(UserType.MEMBER)){
			return "/member";
		}else{
			throw new IllegalAccessError();
		}
	}
	
}
	
			