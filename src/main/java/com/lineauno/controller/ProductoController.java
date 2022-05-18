package com.lineauno.controller;

import com.lineauno.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService service;

    @GetMapping
    public Iterable<Producto> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        return new ResponseEntity<>(service.save(producto), HttpStatus.OK);
    }

    @PutMapping("/{idProd}")
    public ResponseEntity<Producto> update(@RequestBody Producto producto){
        return new ResponseEntity<>(service.update(producto), HttpStatus.OK);
    }

    @GetMapping("/{idProd}")
    public ResponseEntity<Producto> findById(@PathVariable("idProd") Integer idProd){
        return new ResponseEntity<>(service.findById(idProd), HttpStatus.OK);
    }

    @DeleteMapping("/{idProd}")
    public void deleteById(@PathVariable("idProd") Integer idProd){
        service.deleteById(idProd);
    }

}
