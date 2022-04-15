package com.github.dalmofelipe.spring101.exceptions.business;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.dalmofelipe.spring101.exceptions.BaseRuntimeException;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class IpApiUnprocessException extends BaseRuntimeException{

	private static final long serialVersionUID = 1L;
	private static final String KEY = "ip.location.unprocess";
	
	public IpApiUnprocessException() {
	    super();
	}
	
	@Override
	public String getExceptionKey() {
	    return KEY;
	}
}
