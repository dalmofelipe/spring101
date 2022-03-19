package com.github.dalmofelipe.springbootlab.exceptions.business;

import com.github.dalmofelipe.springbootlab.exceptions.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends BaseRuntimeException {
    private static final String KEY = "user.not.found";

    public UserNotFoundException(Long id) {
        super(Map.of("id", id));
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}

