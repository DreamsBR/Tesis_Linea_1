package com.lineauno.service;

import com.lineauno.entity.Tarjeta;
import com.lineauno.utils.GenericResponse;

import java.util.List;
import java.util.Optional;

public interface TarjetaService {

    List<Tarjeta> findAll();
    Tarjeta findById(Integer id);
    Tarjeta save(Tarjeta tarjeta);
    Tarjeta update(Integer id,Tarjeta tarjeta);
    void delete(Integer id);
    GenericResponse<Tarjeta> getTarjetaUsuario(int id);
    
}
