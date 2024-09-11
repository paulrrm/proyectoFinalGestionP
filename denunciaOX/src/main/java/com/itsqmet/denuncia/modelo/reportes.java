package com.itsqmet.denuncia.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;

@Entity @Getter @Setter
public class reportes {

	@Hidden
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@DefaultValueCalculator(CurrentDateCalculator.class)
    private Date fechaalta;
	
	@Column(length = 150) // 
    String descripcion;
	
	@File
	private String foto;
	
	@ManyToOne
	placa placa;
	
	@ManyToOne
	usuario usuario;
}
