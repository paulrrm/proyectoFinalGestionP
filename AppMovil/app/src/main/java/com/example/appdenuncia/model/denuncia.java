package com.example.appdenuncia.model;

import java.util.Date;

public class denuncia {



    private String fechalta;

    private String fecharobo;

    private String color;

    private String modelo;

    private String marca;

    private double valor;

    private String foto;

    private usuario usuario;

    private placa placa;


    public String getFechalta() {
        return fechalta;
    }

    public void setFechalta(String fechalta) {
        this.fechalta = fechalta;
    }

    public String getFecharobo() {
        return fecharobo;
    }

    public void setFecharobo(String fecharobo) {
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
