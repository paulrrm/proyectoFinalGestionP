package com.example.denuncias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.denuncias.model.usuario;

public interface usuarioRepository extends JpaRepository<usuario, Long>{

}
