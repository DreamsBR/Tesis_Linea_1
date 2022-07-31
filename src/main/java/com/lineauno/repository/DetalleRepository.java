package com.lineauno.repository;

import com.lineauno.entity.Detalle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends CrudRepository<Detalle, Integer> {
}
