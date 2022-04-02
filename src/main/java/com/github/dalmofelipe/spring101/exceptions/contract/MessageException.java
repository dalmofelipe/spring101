package com.github.dalmofelipe.spring101.exceptions.contract;

import java.util.Map;

public interface MessageException {

    String getExceptionKey();
    Map<String, Object> getMapDetails();
}