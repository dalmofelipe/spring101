package com.github.dalmofelipe.springbootlab.controllers;

import com.github.dalmofelipe.springbootlab.dtos.UserDto;
import com.github.dalmofelipe.springbootlab.entities.UserEntity;
import com.github.dalmofelipe.springbootlab.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

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
