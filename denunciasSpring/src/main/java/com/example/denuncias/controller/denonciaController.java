package com.example.denuncias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/placas")
    public placa postPlaca(@RequestBody placa plca){
        return placarepository.save(plca);
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
    @GetMapping("/usuario/login/{usr}/{pdw}")
    public ResponseEntity<usuario> getLogin(@PathVariable String usr, @PathVariable String pdw){
        try{
            usuario usuarios = usuariorepository.findByCorreoAndPassword(usr,pdw).get(0);
            return ResponseEntity.ok(usuarios); 
        }catch(Exception ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping("/usuario")
    public usuario postUsuario(@RequestBody usuario usr){
        return usuariorepository.save(usr);
    }
    @GetMapping("/denuncia")
    public ResponseEntity<List<denuncia>> getDenuncia(){
       try{
            List<denuncia> denuncias = denunciarepository.findAll();
            return ResponseEntity.ok(denuncias); 
       }
       catch(Exception ex)
       {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
       }
        
    }
    @PostMapping("/denuncia")
    public denuncia postUsuario(@RequestBody denuncia denun){
        return denunciarepository.save(denun);
    }
    @GetMapping("/reportes")
    public ResponseEntity<List<reportes>> getReportes(){
       try {
        List<reportes> repos = reporterepository.findAll();
        return ResponseEntity.ok(repos);
        
       } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
       }
    }
    @PostMapping("/reporte")
    public reportes postUsuario(@RequestBody reportes repor){
        return reporterepository.save(repor);
    }


}
