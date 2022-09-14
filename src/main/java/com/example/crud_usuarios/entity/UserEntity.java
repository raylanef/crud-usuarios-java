package com.example.crud_usuarios.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="nome")
    private String name;

    @Column(name="idade")
    private Integer age;

    private String cep;
    @Column(name="bairro")
    private String neighborhood;

    @Column(name="localidade")
    private String city;

    @Column(name="uf")
    private String state;
}
