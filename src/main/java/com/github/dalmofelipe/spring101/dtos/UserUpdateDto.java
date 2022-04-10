package com.github.dalmofelipe.spring101.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dalmofelipe.spring101.entities.UserEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class UserUpdateDto {

    @NotBlank(message = "{name.not.blank.validation}")
    private String name;

    @NotBlank(message = "{email.is.required}")
    @Email(message = "{email.invalid}")
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonProperty(value = "birth_date")
    private LocalDate birthDate;

    public UserUpdateDto() {}

    public UserEntity toEntity() {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(this, userEntity);
        return userEntity;
    }
}
