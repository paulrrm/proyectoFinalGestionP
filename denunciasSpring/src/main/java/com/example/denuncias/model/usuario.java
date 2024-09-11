package com.example.denuncias.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class usuario {

	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 50) // 
    String nombre;
    @Column(length = 50) //
    String apellido;
    @Column(length = 150) // 
    String correo;
    @Column(length = 50) // 
    String password;
    
    private Date fechaalta;

    private Date fechabaja;
    
    
}