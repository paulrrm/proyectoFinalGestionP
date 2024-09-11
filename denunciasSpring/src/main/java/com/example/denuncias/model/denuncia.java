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
@Entity @Getter@Setter
public class denuncia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	
    private Date  fechalta;
	

	 
	 private Date fecharobo;
	 

	 
	 @Column(length = 20) // 
	 String color;
	 @Column(length = 50) // 
	 String modelo;
	 @Column(length = 50) // 
	 String marca;
	 private double valor;

	 private String foto;
	 
	 @ManyToOne
	 usuario usuario;
	 
	 @ManyToOne
	 placa placa;
}
