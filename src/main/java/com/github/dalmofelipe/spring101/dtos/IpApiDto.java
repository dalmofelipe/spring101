package com.github.dalmofelipe.spring101.dtos;

import lombok.Data;

@Data
public class IpApiDto {

	private String status;
	private String query;
	private String country;
	private String regionName;
	private String region;
	private String city;
	private String countryCode;
	private Float lon;
	private Float lat;
	private String as;
	private String org;
	private String timezone;
	private String isp;
}
