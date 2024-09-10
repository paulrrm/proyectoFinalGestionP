package com.itsqmet.denuncia.modelo;

import java.util.*;

import javax.persistence.*;

import lombok.*;

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
    @Column(name = "fechaAlta", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date fechaAlta;
    @Column(name = "fechaBaja", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date fechaBaja;
    
    
}
