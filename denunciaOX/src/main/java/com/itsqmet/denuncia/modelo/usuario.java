package com.itsqmet.denuncia.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;

@Entity @Getter @Setter
public class usuario {

	@Hidden
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
    @Required
    @DefaultValueCalculator(CurrentDateCalculator.class)
    private Date fechaAlta;
    @Hidden
    @Column(name = "fechaBaja")
    private Date fechaBaja;
    
    
}
