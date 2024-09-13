package com.example.appdenuncia.model;

import java.util.Date;

public class denunciaGet {
    private Long id;

    private Date fechalta;

    private Date fecharobo;

    private String color;

    private String modelo;

    private String marca;

    private double valor;

    private String foto;

    private usuario usuario;

    private placa placa;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechalta() {
        return fechalta;
    }

    public void setFechalta(Date fechalta) {
        this.fechalta = fechalta;
    }

    public Date getFecharobo() {
        return fecharobo;
    }

    public void setFecharobo(Date fecharobo) {
        this.fecharobo = fecharobo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public com.example.appdenuncia.model.usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(com.example.appdenuncia.model.usuario usuario) {
        this.usuario = usuario;
    }

    public com.example.appdenuncia.model.placa getPlaca() {
        return placa;
    }

    public void setPlaca(com.example.appdenuncia.model.placa placa) {
        this.placa = placa;
    }
}
