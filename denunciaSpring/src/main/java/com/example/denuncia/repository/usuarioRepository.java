package com.example.denuncia.repository;

import com.example.denuncia.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuarioRepository extends JpaRepository<usuario, Long> {

}
