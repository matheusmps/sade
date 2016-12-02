package com.mc437.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mc437.model.UserType;

@Component
public class RoleToUserTypeConverter implements Converter<Object, UserType> {

	static final Logger logger = LoggerFactory.getLogger(RoleToUserTypeConverter.class);
	
	@Override
	public UserType convert(Object element) {
		UserType type = UserType.findUserType((String) element);
		logger.info("Type : {}", type);
		return type;
	}

	
	
}
