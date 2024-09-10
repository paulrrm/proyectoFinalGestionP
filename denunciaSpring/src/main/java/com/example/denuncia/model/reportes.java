package com.example.denuncia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class reportes {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaAlta", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date fechaAlta;

    @Column(length = 150) //
    String descripcion;

    @ManyToOne
    usuario usuario;
}
