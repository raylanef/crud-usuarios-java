package com.example.crud_usuarios.repository;

import com.example.crud_usuarios.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByName(String name);
}
