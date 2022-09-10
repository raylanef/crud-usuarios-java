package com.example.CRUDUsuarios.repository;

import com.example.CRUDUsuarios.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByName(String name);
}
