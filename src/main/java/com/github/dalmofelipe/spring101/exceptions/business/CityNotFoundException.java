package com.github.dalmofelipe.spring101.exceptions.business;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.dalmofelipe.spring101.exceptions.BaseRuntimeException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CityNotFoundException extends BaseRuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String KEY = "city.not.found";
	
	public CityNotFoundException(String name, String UF) {
	    super(Map.of("name", name, "UF", UF));
	}
	
	@Override
	public String getExceptionKey() {
	    return KEY;
	}
}
