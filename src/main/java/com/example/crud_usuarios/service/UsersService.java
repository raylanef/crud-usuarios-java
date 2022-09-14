package com.example.crud_usuarios.service;


import com.example.crud_usuarios.controller.dtos.UserDto;
import com.example.crud_usuarios.entity.UserEntity;
import com.example.crud_usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(int id) throws ChangeSetPersister.NotFoundException {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        return toDto(entity);
    }

    public void add(UserDto dto) {
        var entity = toEntity(dto);
        userRepository.save(entity);
    }

    public void update(int id, UserDto dto) {
        dto.setId(id);
        var entity = toEntity(dto);
        userRepository.save(entity);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    private UserEntity toEntity(UserDto dto) {
        var entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setCep(dto.getCity());
        entity.setCity(dto.getCity());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setState(dto.getState());

        return entity;
    }

    private UserDto toDto(UserEntity entity) {
        var dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setCep(entity.getCity());
        dto.setCity(entity.getCity());
        dto.setNeighborhood(entity.getNeighborhood());
        dto.setState(entity.getState());

        return dto;

    }
}
