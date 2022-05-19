package com.lineauno.repository;

import com.lineauno.entity.TipoTarjeta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTarjetaRepository extends CrudRepository<TipoTarjeta, Integer> {


}
