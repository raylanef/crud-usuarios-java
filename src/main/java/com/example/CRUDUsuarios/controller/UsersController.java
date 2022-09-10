package com.example.CRUDUsuarios.controller;

import com.example.CRUDUsuarios.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.CRUDUsuarios.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User postUser(@RequestBody User newUser){
        userRepository.save(newUser);
        return newUser;
    }

    @PutMapping("/{position}")
    public User userUpdate(@PathVariable int position,
                           @RequestBody User user){

        user.setId(position);
        userRepository.save(user);
        return null;
    }

    @DeleteMapping("/{position}")
    public String deleteUser(@PathVariable int position) {
        userRepository.deleteById(position);
        return "Usuário não encontrado";
    }

}
