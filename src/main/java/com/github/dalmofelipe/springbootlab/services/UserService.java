package com.github.dalmofelipe.springbootlab.services;

import com.github.dalmofelipe.springbootlab.dtos.UserDto;
import com.github.dalmofelipe.springbootlab.entities.UserEntity;
import com.github.dalmofelipe.springbootlab.exceptions.business.UserNotFoundException;
import com.github.dalmofelipe.springbootlab.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAll() {
        return this.userRepository.findAll();
    }

    public UserEntity getById(Long id) {
        Optional<UserEntity> userOpt = this.userRepository.findById(id);
        if(userOpt.isEmpty()) throw new UserNotFoundException(id);
        UserEntity user = userOpt.get();
        return user;
    }

    public void save(@Valid UserDto userDto) {
        UserEntity user = userDto.toEntity();
        this.userRepository.save(user);
    }
}
