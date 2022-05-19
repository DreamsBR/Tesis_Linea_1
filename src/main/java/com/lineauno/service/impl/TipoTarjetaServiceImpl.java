package com.lineauno.service.impl;

import com.lineauno.entity.TipoTarjeta;
import com.lineauno.repository.TipoTarjetaRepository;
import com.lineauno.service.TipoTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoTarjetaServiceImpl implements TipoTarjetaService {

    @Autowired
    private TipoTarjetaRepository tipoTarjetaRepository;

    @Override
    public List<TipoTarjeta> findAll() {
        return (List<TipoTarjeta>) tipoTarjetaRepository.findAll();
    }

    @Override
    public TipoTarjeta findById(Integer id) {
        return tipoTarjetaRepository.findById(id).get();
    }

    @Override
    public TipoTarjeta save(TipoTarjeta tipoTarjeta) {
        return tipoTarjetaRepository.save(tipoTarjeta);
    }

    @Override
    public TipoTarjeta update(Integer id, TipoTarjeta tipoTarjeta) {
        TipoTarjeta objTipoTarjeta = tipoTarjetaRepository.findById(id).get();
        objTipoTarjeta.setDescripcion(tipoTarjeta.getDescripcion());
        return tipoTarjetaRepository.save(objTipoTarjeta);
    }

    @Override
    public void delete(Integer id) {
        tipoTarjetaRepository.deleteById(id);
    }
}
