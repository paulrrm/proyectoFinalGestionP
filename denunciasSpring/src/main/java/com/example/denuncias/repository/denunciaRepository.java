package com.example.denuncias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.denuncias.model.denuncia;

public interface denunciaRepository extends JpaRepository<denuncia, Long> {

    
}
