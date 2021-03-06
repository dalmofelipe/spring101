package com.github.dalmofelipe.spring101.dtos;

import com.github.dalmofelipe.spring101.entities.UserEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @NotBlank(message = "{name.not.blank.validation}")
    private String name;

    @NotBlank(message = "{email.is.required}")
    @Email(message = "{email.invalid}")
    private String email;

    @NotBlank
    @Size(min = 6, max = 10, message = "{password.validation}")
    private String password;

    public UserDto() {}

    public UserEntity toEntity() {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(this, userEntity);
        return userEntity;
    }
}
