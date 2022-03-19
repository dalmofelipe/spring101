package com.github.dalmofelipe.springbootlab.controllers;

import com.github.dalmofelipe.springbootlab.dtos.UserDto;
import org.springframework.web.bind.annotation.*;

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
