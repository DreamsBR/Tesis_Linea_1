package com.lineauno.service.impl;

import com.lineauno.entity.Movimiento;
import com.lineauno.repository.MovimientoRepository;
import com.lineauno.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public List<Movimiento> findAll() {
        return (List<Movimiento>) movimientoRepository.findAll();
    }

    @Override
    public Movimiento findById(Integer id) {
        return movimientoRepository.findById(id).get();
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public Movimiento update(Integer id, Movimiento movimiento) {
        Movimiento objMovimiento = movimientoRepository.findById(id).get();
        objMovimiento.setFecha(LocalDate.now());
        objMovimiento.setTarjeta(movimiento.getTarjeta());
        objMovimiento.setUsuario(movimiento.getUsuario());
        objMovimiento.setMonto_total(movimiento.getMonto_total());
        return movimientoRepository.save(objMovimiento);
    }

    @Override
    public void delete(Integer id) {
        movimientoRepository.deleteById(id);
    }
}
