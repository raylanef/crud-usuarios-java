package com.example.crud_usuarios.service;

import com.example.crud_usuarios.entity.User;
import com.example.crud_usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id) throws ChangeSetPersister.NotFoundException {
       return  userRepository.findById(id)
               .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void add(User newUser) {
        userRepository.save(newUser);
    }

    public void update(int id, User user){
        user.setId(id);
        userRepository.save(user);
    }

    public void delete(int id){
        userRepository.deleteById(id);
    }
}
