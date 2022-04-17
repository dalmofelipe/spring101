package com.github.dalmofelipe.spring101.exceptions.business;

import com.github.dalmofelipe.spring101.exceptions.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class RegisterCityIdOnTokenUnproccessException extends BaseRuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String KEY = "register.city.id.unprocess";

	public RegisterCityIdOnTokenUnproccessException() {
	    super();
	}
	
	@Override
	public String getExceptionKey() {
	    return KEY;
	}
}
