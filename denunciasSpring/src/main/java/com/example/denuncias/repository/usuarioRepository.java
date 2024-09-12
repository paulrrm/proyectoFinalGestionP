package com.example.denuncias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.denuncias.model.usuario;

public interface usuarioRepository extends JpaRepository<usuario, Long>{

   List<usuario> findByCorreoAndPassword(String email, String password);

}
