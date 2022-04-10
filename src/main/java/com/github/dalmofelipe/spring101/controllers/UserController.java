package com.github.dalmofelipe.spring101.controllers;

import com.github.dalmofelipe.spring101.dtos.UserDto;
import com.github.dalmofelipe.spring101.dtos.UserUpdateDto;
import com.github.dalmofelipe.spring101.entities.UserEntity;
import com.github.dalmofelipe.spring101.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
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
        UserEntity user = userDto.toEntity();
        this.userService.save(user);
    }

    @PutMapping("/{id}")
    public UserEntity update(@Valid @RequestBody UserUpdateDto userUpdateDto, @PathVariable Long id) {
        UserEntity user = this.userService.getById(id);
        user.setName(userUpdateDto.getName());
        user.setEmail(userUpdateDto.getEmail());
        user.setBirthDate(userUpdateDto.getBirthDate());
        if(user.getBirthDate() != null)
            user.setAge(Period.between(user.getBirthDate(), LocalDate.now()).getYears());
        this.userService.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public Long remote(@PathVariable Long id) {
        this.userService.destroy(id);
        return id;
    }
}
