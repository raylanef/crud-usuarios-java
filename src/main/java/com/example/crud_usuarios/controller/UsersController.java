package com.example.crud_usuarios.controller;

import com.example.crud_usuarios.entity.User;
import com.example.crud_usuarios.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<User> getUsers(){
       return  usersService.listUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) throws ChangeSetPersister.NotFoundException {
        try {
            return ResponseEntity.ok(usersService.getUserById(id));
        } catch (ChangeSetPersister.NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> postUser(@RequestBody User newUser){
            usersService.add(newUser);
            return new ResponseEntity<>("Usuário Cadastrado", HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> userUpdate(@PathVariable int id,
                                             @RequestBody User user){
        usersService.update(id,user);
        return new ResponseEntity<>("Usuário Atualizado", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        usersService.delete(id);
        return new ResponseEntity<>("Usuário deletado com sucesso", HttpStatus.OK);
    }

}
