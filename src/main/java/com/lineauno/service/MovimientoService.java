package com.lineauno.service;


import com.lineauno.dto.GenerarMovimientoDTO;
import com.lineauno.entity.Movimiento;
import com.lineauno.utils.GenericResponse;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovimientoService {

    List<Movimiento> findAll();
    Movimiento findById(Integer id);
    Movimiento save(Movimiento movimiento);
    Movimiento update(Integer id, Movimiento movimiento);
    void delete(Integer id);
    GenericResponse<List<Movimiento>> getLastFiveMovements(String email);
    GenericResponse recargarSaldo(GenerarMovimientoDTO dto);
    double getMontoTotal(@Param("email") String email);
    ResponseEntity<Resource> exportInvoice();
}
