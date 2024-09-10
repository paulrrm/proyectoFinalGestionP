package com.example.denuncia.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Type.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class denuncia {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
    private double valor;

    @ManyToOne
    usuario usuario;


}
