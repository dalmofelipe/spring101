package com.github.dalmofelipe.springbootlab.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    private String name;
    private String email;

    @NotNull
    @Size(min = 6, max = 10, message = "A senha deve ter no minimo 6 e no maximo 10 caracteres")
    private String password;
}
