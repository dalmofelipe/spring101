package com.github.dalmofelipe.spring101.controllers;

import com.github.dalmofelipe.spring101.dtos.CityIDsRegisterDto;
import com.github.dalmofelipe.spring101.dtos.ResponseManagerTokenDto;
import com.github.dalmofelipe.spring101.services.TokenManagerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenManagerController {

    private final TokenManagerService tokenManagerService;

    public TokenManagerController(TokenManagerService tokenManagerService) {
        this.tokenManagerService = tokenManagerService;
    }

    @PutMapping("/register/city-id")
    public ResponseManagerTokenDto registerCityIdOnToken(@RequestBody CityIDsRegisterDto cityIds) {
        return tokenManagerService.registerCityIdOnToken(cityIds);
    }
}
