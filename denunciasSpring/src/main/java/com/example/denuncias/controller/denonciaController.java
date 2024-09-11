package com.example.denuncias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.denuncias.model.denuncia;
import com.example.denuncias.model.placa;
import com.example.denuncias.model.reportes;
import com.example.denuncias.model.usuario;
import com.example.denuncias.repository.denunciaRepository;
import com.example.denuncias.repository.placaRepository;
import com.example.denuncias.repository.reporteRepository;
import com.example.denuncias.repository.usuarioRepository;

@RestController
@RequestMapping("/robo")
public class denonciaController {

    @Autowired
    placaRepository placarepository;
    @Autowired
    usuarioRepository usuariorepository;
    @Autowired
    denunciaRepository denunciarepository;
    @Autowired
    reporteRepository reporterepository;

     @GetMapping("/holamundo")
    public String holamundo(){
        return "hola esto es una prueba del cambio";
    }
    @GetMapping("/placas")
    public ResponseEntity<List<placa>> getPlaca(){
        try{
            List<placa> placas = placarepository.findAll();
            return ResponseEntity.ok(placas); 
        }catch(Exception ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/usuario")
    public ResponseEntity<List<usuario>> getUsuario(){
        try{
            List<usuario> usuarios = usuariorepository.findAll();
            return ResponseEntity.ok(usuarios); 
        }catch(Exception ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/denuncia")
    public List<denuncia> getDenuncia(){
        return denunciarepository.findAll();
    }
    @GetMapping("/reportes")
    public List<reportes> getReportes(){
        return reporterepository.findAll();
    }


}
