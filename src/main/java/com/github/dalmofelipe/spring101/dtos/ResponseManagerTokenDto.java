package com.github.dalmofelipe.spring101.dtos;

import lombok.Data;

@Data
public class ResponseManagerTokenDto {

	private Boolean error;
	private String detail;
	private Integer max_allowed;
	private String status;
	private Integer[] locales;
}
