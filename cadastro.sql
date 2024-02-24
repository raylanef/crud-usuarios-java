CREATE DATABASE IF NOT EXISTS cadastro DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE cadastro;

CREATE TABLE IF NOT EXISTS usuarios(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    idade CHAR(3),
    cep VARCHAR(8),
    bairro VARCHAR(100),
    localidade VARCHAR(100),
    uf VARCHAR(2)
);

INSERT INTO usuarios(nome,idade,cep,bairro,localidade,uf)
VALUES  ('Raylane', 29, '03040020','bras','são paulo','sp'),
        ('John', 29, '03040020','bras','são paulo','sp');