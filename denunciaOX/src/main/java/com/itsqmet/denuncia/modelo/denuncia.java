package com.itsqmet.denuncia.modelo;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class denuncia {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "fechaAlta", columnDefinition = "DATE DEFAULT CURRENT_DATE")
	    private Date fechaAlta;
	
	 @Column(name = "fechaRobo")
	 @NonNull
	 private Date fechaRobo;
	 
	 @Column(length = 10) // 
	 String placa;
	 
	 @Column(length = 20) // 
	 String color;
	 @Column(length = 50) // 
	 String modelo;
	 @Column(length = 50) // 
	 String marca;
	 @Column(precision = 10, scale = 2)
	 @Type(type = "big_decimal")
	 private double valor;
	 
	 @ManyToOne
	 usuario usuario;
	
	
}
