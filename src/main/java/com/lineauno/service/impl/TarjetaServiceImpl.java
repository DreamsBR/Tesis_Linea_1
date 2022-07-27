package com.lineauno.service.impl;

import com.lineauno.entity.Tarjeta;
import com.lineauno.entity.Usuario;
import com.lineauno.repository.TarjetaRepository;
import com.lineauno.service.TarjetaService;
import com.lineauno.utils.GenericResponse;
import com.lineauno.utils.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TarjetaServiceImpl implements TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Override
    public List<Tarjeta> findAll() {
        return (List<Tarjeta>) tarjetaRepository.findAll();
    }

    @Override
    public Tarjeta findById(Integer id) {
        return tarjetaRepository.findById(id).get();
    }

    @Override
    public Tarjeta save(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public Tarjeta update(Integer id, Tarjeta tarjeta) {
        Tarjeta objTarjeta = tarjetaRepository.findById(id).get();
        objTarjeta.setCodigo(tarjeta.getCodigo());
        objTarjeta.setTipo_tarjeta(tarjeta.getTipo_tarjeta());
        objTarjeta.setAnio_compra(tarjeta.getAnio_compra());
        objTarjeta.setAnio_vencimiento(tarjeta.getAnio_vencimiento());
        objTarjeta.setSaldo(tarjeta.getSaldo());
        objTarjeta.setEstado(tarjeta.getEstado());
        return tarjetaRepository.save(objTarjeta);
    }

    @Override
    public void delete(Integer id) {
        tarjetaRepository.deleteById(id);
    }

    @Override
    public GenericResponse<Tarjeta> getTarjetaUsuario(int id) {
        Optional<Tarjeta> optionalTarjeta = this.tarjetaRepository.getTarjetaUsuario(id);
        if (optionalTarjeta.isPresent()) {
            return new GenericResponse<>(Globals.TIPO_AUTH, Globals.RPTA_OK, "Tarjeta encontrada", optionalTarjeta.get());
        }
        else {
            return new GenericResponse<>(Globals.TIPO_AUTH, Globals.RPTA_WARNING, "Tarjeta no encontrada", new Tarjeta());
        }
    }
}
