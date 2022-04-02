package com.github.dalmofelipe.spring101.exceptions.business;

import com.github.dalmofelipe.spring101.exceptions.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoPassRuleException extends BaseRuntimeException {

    private static final String KEY = "no.password.validation";

    public NoPassRuleException() {
        super();
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}
