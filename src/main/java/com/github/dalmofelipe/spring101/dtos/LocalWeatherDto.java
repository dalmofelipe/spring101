package com.github.dalmofelipe.spring101.dtos;

import lombok.Data;

@Data
public class LocalWeatherDto {

	private Integer id;
	private String name;
	private String state;
	private String country;
	private WeatherDto data;
}
