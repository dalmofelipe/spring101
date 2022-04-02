package com.github.dalmofelipe.spring101.controllers;

import com.github.dalmofelipe.spring101.dtos.UserDto;
import com.github.dalmofelipe.spring101.entities.UserEntity;
import com.github.dalmofelipe.spring101.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public UserEntity getOne(@PathVariable Long id) {
        return this.userService.getById(id);
    }

    @PostMapping
    public void save(@Valid @RequestBody UserDto userDto) {
        this.userService.save(userDto);
    }
}
