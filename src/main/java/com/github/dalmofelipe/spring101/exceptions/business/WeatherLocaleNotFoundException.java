package com.github.dalmofelipe.spring101.exceptions.business;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.dalmofelipe.spring101.exceptions.BaseRuntimeException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WeatherLocaleNotFoundException extends BaseRuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String KEY = "weather.locale.not.found";
	
	public WeatherLocaleNotFoundException(Integer idCidy) {
	    super(Map.of("idCity", idCidy));
	}
	
	@Override
	public String getExceptionKey() {
	    return KEY;
	}
}
