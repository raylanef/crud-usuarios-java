package com.example.CRUDUsuarios.controller;

import com.example.CRUDUsuarios.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> postUser(@RequestBody User newUser){
        try {
            userRepository.save(newUser);
            return new ResponseEntity<String>("Usuário Cadastrado", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Deu ruim :(",
                                                HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> userUpdate(@PathVariable int id,
                                             @RequestBody User user){

        user.setId(id);
        userRepository.save(user);
        return new ResponseEntity<String>("Usuário Atualizado", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return new ResponseEntity<String>("Usuário deletado com sucesso", HttpStatus.CREATED);
    }

}
