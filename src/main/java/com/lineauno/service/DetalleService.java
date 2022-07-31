package com.lineauno.service;

import com.lineauno.entity.Detalle;
import com.lineauno.repository.DetalleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DetalleService {

    private final DetalleRepository repository;

    public DetalleService(DetalleRepository repository) {
        super();
        this.repository = repository;
    };

    public void guardarDetalle(Detalle detalle) {
        this.repository.save(detalle);
    }
}
