package com.example.denuncia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.DateJdbcType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


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

    @Column(name = "fechabaja")
    private Date fechaBaja;


}
