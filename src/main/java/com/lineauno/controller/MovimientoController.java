package com.lineauno.controller;

import com.lineauno.entity.Movimiento;
import com.lineauno.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movimiento")
public class MovimientoController {
    
    @Autowired
    private MovimientoService movimientoService;


    @GetMapping
    public List<Movimiento> findAll(){
        return movimientoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Movimiento> save(@RequestBody Movimiento movimiento){
        return new ResponseEntity<>(movimientoService.save(movimiento), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> update(@PathVariable("id") Integer id, @RequestBody Movimiento movimiento){
        return new ResponseEntity<>(movimientoService.update(id, movimiento), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(movimientoService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        movimientoService.delete(id);
    }

    @GetMapping("/historial")
    public List<Movimiento> getLastFiveMovements(){
        return movimientoService.getLastFiveMovements();
    }
}
