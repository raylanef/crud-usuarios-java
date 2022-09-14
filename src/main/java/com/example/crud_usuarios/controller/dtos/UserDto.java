package com.example.crud_usuarios.controller.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String name;
    private Integer age;
    private String cep;
    private String neighborhood;
    private String city;
    private String state;

    @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Integer id) {
        this.id = id;
    }
}
