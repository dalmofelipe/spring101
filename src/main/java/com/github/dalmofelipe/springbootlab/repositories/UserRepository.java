package com.github.dalmofelipe.springbootlab.repositories;

import com.github.dalmofelipe.springbootlab.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
