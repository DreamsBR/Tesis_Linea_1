package com.lineauno.repository;

import com.lineauno.entity.Tarjeta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository  extends CrudRepository<Tarjeta,Integer> {
}
