package com.lineauno.service;


import com.lineauno.entity.Movimiento;

import java.util.List;

public interface MovimientoService {

    List<Movimiento> findAll();
    Movimiento findById(Integer id);
    Movimiento save(Movimiento movimiento);
    Movimiento update(Integer id, Movimiento movimiento);
    void delete(Integer id);
    List<Movimiento> getLastFiveMovements();

}
