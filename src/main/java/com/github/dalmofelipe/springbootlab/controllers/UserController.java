package com.github.dalmofelipe.springbootlab.controllers;

import com.github.dalmofelipe.springbootlab.dtos.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getAll() {
        return "Lista de usuários ...";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id) {
        return "ID Usuario retornado: " + id;
    }

    @PostMapping
    public UserDto save(@Valid @RequestBody UserDto userDto) {
        return userDto;
    }
}
