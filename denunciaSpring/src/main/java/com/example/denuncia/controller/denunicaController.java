package com.example.denuncia.controller;

import com.example.denuncia.model.placa;
import com.example.denuncia.model.usuario;
import com.example.denuncia.repository.denunciaRepository;
import com.example.denuncia.repository.placaRepository;
import com.example.denuncia.repository.reportesRepository;
import com.example.denuncia.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/robo")
public class denunicaController {
    @Autowired
    placaRepository placarepository;
    @Autowired
    usuarioRepository userrepository;
    @Autowired
    denunciaRepository denunciarepository;
    @Autowired
    reportesRepository reportesrepository;


    @GetMapping("/holamundo")
    public String holamundo(){
        return "hola esto es una prueba del cambio";
    }
    @GetMapping("/placas")
    public List<placa> getPlaca(){
        return placarepository.findAll();
    }

    @GetMapping("/usuarios")
    public List<usuario> getUsuario(){
        return userrepository.findAll();
    }

}
