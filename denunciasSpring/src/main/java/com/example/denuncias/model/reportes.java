package com.example.denuncias.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Entity @Getter @Setter
public class reportes {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	

    private Date fechaalta;
	
	@Column(length = 150) // 
    String descripcion;
	

	private String foto;
	
	@ManyToOne
	placa placa;
	
	@ManyToOne
	usuario usuario;
}