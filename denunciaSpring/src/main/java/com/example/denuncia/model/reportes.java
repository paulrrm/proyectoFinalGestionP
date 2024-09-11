package com.example.denuncia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity @Getter @Setter
public class reportes {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    private LocalDate fechaalta;

    @Column(length = 150) //
    String descripcion;


    private String foto;

    @ManyToOne
    placa placa;

    @ManyToOne
    usuario usuario;
}
