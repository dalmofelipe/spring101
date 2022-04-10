package com.github.dalmofelipe.spring101.services;

import com.github.dalmofelipe.spring101.entities.UserEntity;
import com.github.dalmofelipe.spring101.exceptions.business.UserNotFoundException;
import com.github.dalmofelipe.spring101.repositories.UserRepository;
import org.springframework.stereotype.Service;

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

    public void save(UserEntity user) {
        this.userRepository.save(user);
    }

    public void destroy(Long id) {
         Optional<UserEntity> userOpt = this.userRepository.findById(id);
        if(userOpt.isEmpty()) throw new UserNotFoundException(id);
        UserEntity user = userOpt.get();
        this.userRepository.delete(user);
    }
}
