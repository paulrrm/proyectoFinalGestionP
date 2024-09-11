package com.itsqmet.denuncia.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;

@Entity @Getter @Setter
public class denuncia {

	@Hidden
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@DefaultValueCalculator(CurrentLocalDateCalculator.class)
    private LocalDate  fechaAlta;
	
	 @Column(name = "fechaRobo")
	 @NonNull
	 private Date fechaRobo;
	 

	 
	 @Column(length = 20) // 
	 String color;
	 @Column(length = 50) // 
	 String modelo;
	 @Column(length = 50) // 
	 String marca;
	 @Column(precision = 10, scale = 2)
	 
	 @Money
	 private double valor;
	 
	 @Files
	 private String foto;
	 
	 @ManyToOne
	 usuario usuario;
	 
	 @ManyToOne
	 placa placa;
	
	
}
