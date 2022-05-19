package com.lineauno.controller;

import com.lineauno.entity.Tarjeta;
import com.lineauno.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tarjeta")
public class TarjetaController {

    @Autowired
    TarjetaService tarjetaService;

    @GetMapping
    public List<Tarjeta> findAll(){
        return tarjetaService.findAll();
    }

    @PostMapping
    public ResponseEntity<Tarjeta> save(@RequestBody Tarjeta Tarjeta){
        return new ResponseEntity<>(tarjetaService.save(Tarjeta), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarjeta> update(@PathVariable("id") Integer id, @RequestBody Tarjeta tarjeta){
        return new ResponseEntity<>(tarjetaService.update(id, tarjeta), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarjeta> findById(@PathVariable("id") Integer id){
        return new ResponseEntity(tarjetaService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        tarjetaService.delete(id);
    }

}
