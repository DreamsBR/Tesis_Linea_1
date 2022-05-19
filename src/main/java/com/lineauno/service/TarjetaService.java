package com.lineauno.service;

import com.lineauno.entity.Tarjeta;

import java.util.List;

public interface TarjetaService {

    List<Tarjeta> findAll();
    Tarjeta findById(Integer id);
    Tarjeta save(Tarjeta tarjeta);
    Tarjeta update(Integer id,Tarjeta tarjeta);
    void delete(Integer id);
    
}
