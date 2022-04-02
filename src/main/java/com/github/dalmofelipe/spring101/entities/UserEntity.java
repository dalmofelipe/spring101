package com.github.dalmofelipe.spring101.entities;

import com.github.dalmofelipe.spring101.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_users")
@Data
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private LocalDate birthDate;
    private String email;
    private String password;

    public UserEntity() {}

    public UserDto toDto() {
        UserDto userDto = new UserDto();
        userDto.setName(this.name);
        userDto.setEmail(this.email);
        userDto.setPassword(this.password);
        return userDto;
    }
}
