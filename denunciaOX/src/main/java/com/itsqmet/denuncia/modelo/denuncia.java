package com.itsqmet.denuncia.modelo;

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
	
	@DefaultValueCalculator(CurrentDateCalculator.class)
    private Date  fechalta;
	
	 @Column(name = "fechaRobo")
	 @NonNull
	 private Date fecharobo;
	 

	 
	 @Column(length = 20) // 
	 String color;
	 @Column(length = 50) // 
	 String modelo;
	 @Column(length = 50) // 
	 String marca;
	 @Column(precision = 10, scale = 2)
	 
	 @Money
	 private double valor;
	 
	 @File
	 private String foto;
	 
	 @ManyToOne
	 usuario usuario;
	 
	 @ManyToOne
	 placa placa;
	
	
}
