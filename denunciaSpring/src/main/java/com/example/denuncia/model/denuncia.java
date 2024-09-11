package com.example.denuncia.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Type.*;

import java.time.LocalDate;
import java.util.Date;

@Entity @Getter @Setter
public class denuncia {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    private LocalDate fechaalta;

    @Column(name = "fechaRobo")
    @NonNull
    private Date fecharobo;



    @Column(length = 20) //
    String color;
    @Column(length = 50) //
    String modelo;
    @Column(length = 50) //
    String marca;



    private double valor;


    private String foto;

    @ManyToOne
    usuario usuario;

    @ManyToOne
    placa placa;


}
