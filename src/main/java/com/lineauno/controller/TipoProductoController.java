package com.lineauno.controller;

import com.lineauno.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipoproducto")
public class TipoProductoController {

    @Autowired
    private TipoProductoService tipoProductoService;

    @GetMapping
    public List<TipoProducto> ObtenerProductos (){
        return tipoProductoService.getTipoProducto();
    }
}
