package com.lineauno.service;

import com.lineauno.entity.TipoTarjeta;
import java.util.List;

public interface TipoTarjetaService {

 List<TipoTarjeta> findAll();
 TipoTarjeta findById(Integer id);
 TipoTarjeta save(TipoTarjeta tipoTarjeta);
 TipoTarjeta update(Integer id, TipoTarjeta tipoTarjeta);
 void delete(Integer id);

}
