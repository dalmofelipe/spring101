package com.github.dalmofelipe.spring101.exceptions.dto;

import com.github.dalmofelipe.spring101.exceptions.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorDto {

    private Date timestamp;
    private Integer status;
    private String code;
    private Set<ErrorDto> errors;
}