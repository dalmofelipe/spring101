package com.github.dalmofelipe.springbootlab.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tb_users")
@Data
@AllArgsConstructor
public class UserEntity {

    @Id
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate birthDate;
}
