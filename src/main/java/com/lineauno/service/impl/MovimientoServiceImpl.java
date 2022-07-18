package com.lineauno.service.impl;

import com.lineauno.dto.GenerarMovimientoDTO;
import com.lineauno.entity.Movimiento;
import com.lineauno.repository.MovimientoRepository;
import com.lineauno.service.DetalleService;
import com.lineauno.service.MovimientoService;
import com.lineauno.utils.GenericResponse;
import com.lineauno.utils.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private DetalleService detalleService;

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
        objMovimiento.setFecha(movimiento.getFecha());
        objMovimiento.setTarjeta(movimiento.getTarjeta());
        //objMovimiento.setUsuario(movimiento.getUsuario());
        objMovimiento.setMonto_total(movimiento.getMonto_total());
        return movimientoRepository.save(objMovimiento);
    }

    @Override
    public void delete(Integer id) {
        movimientoRepository.deleteById(id);
    }

    @Override
    public GenericResponse getLastFiveMovements(String email) {
        return new GenericResponse(Globals.TIPO_DATA, Globals.RPTA_OK, Globals.OPERACION_CORRECTA, this.movimientoRepository.getLastFiveMovements(email));
    }

    @Override
    public GenericResponse recargarSaldo(GenerarMovimientoDTO dto) {
        Date date = new Date();
        dto.getMovimiento().setFecha(new java.sql.Date(date.getTime()));
        dto.getMovimiento().setMonto_total(dto.getMovimiento().getMonto_total());
        dto.getMovimiento().getTarjeta().setCliente(dto.getCliente());
        dto.getMovimiento().setEmail(dto.getMovimiento().getEmail());
        System.out.println("Cliente Servicio:--> " + dto.getCliente().getId());
        dto.getMovimiento().setToken(dto.getMovimiento().getToken());
        System.out.println("Token Servicio:--> " + dto.getMovimiento().getToken());
        System.out.println("Token Servicio:--> " + dto.getMovimiento().getEmail());
        this.movimientoRepository.save(dto.getMovimiento());
        this.detalleService.guardarDetalle(dto.getDetalle());
        return new GenericResponse(Globals.TIPO_DATA, Globals.RPTA_OK, Globals.OPERACION_CORRECTA, dto);
    }


}
