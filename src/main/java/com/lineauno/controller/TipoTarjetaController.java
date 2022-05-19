package com.lineauno.controller;

import com.lineauno.entity.TipoTarjeta;
import com.lineauno.service.TipoTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipoTarjeta")
public class TipoTarjetaController {

    @Autowired
    private TipoTarjetaService tipoTarjetaService;

    @GetMapping
    public List<TipoTarjeta> findAll(){
        return tipoTarjetaService.findAll();
    }

    @PostMapping
    public ResponseEntity<TipoTarjeta> save(@RequestBody TipoTarjeta tipoTarjeta){
        return new ResponseEntity<>(tipoTarjetaService.save(tipoTarjeta), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoTarjeta> update(@PathVariable("id") Integer id, @RequestBody TipoTarjeta tipoTarjeta){
        return new ResponseEntity<>(tipoTarjetaService.update(id, tipoTarjeta), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoTarjeta> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(tipoTarjetaService.findById(id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        tipoTarjetaService.delete(id);
    }
}
