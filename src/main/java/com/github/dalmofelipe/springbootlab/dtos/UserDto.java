package com.github.dalmofelipe.springbootlab.dtos;

import com.github.dalmofelipe.springbootlab.entities.UserEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 10, message = "{no.password.validation}")
    private String password;

    public UserDto() {}

    public UserEntity toEntity() {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(this, userEntity);
        return userEntity;
    }
}
