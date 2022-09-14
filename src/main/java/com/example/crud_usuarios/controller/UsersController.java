package com.example.crud_usuarios.controller;


import com.example.crud_usuarios.controller.dtos.UserDto;
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
    public ResponseEntity<List<UserDto>> getUsers(){
       return ResponseEntity.ok(usersService.listUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) throws ChangeSetPersister.NotFoundException {
            return ResponseEntity.ok(usersService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<String> postUser(@RequestBody UserDto newUserDto){
            usersService.add(newUserDto);
            return new ResponseEntity<>("Usuário Cadastrado", HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> userUpdate(@PathVariable int id,
                                             @RequestBody UserDto userDto){
        usersService.update(id, userDto);
        return new ResponseEntity<>("Usuário Atualizado", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        usersService.delete(id);
        return new ResponseEntity<>("Usuário deletado com sucesso", HttpStatus.OK);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<?> handlerException(){
        return new ResponseEntity<>("Nenhum usuário encontrado", HttpStatus.NOT_FOUND);
    }

}
