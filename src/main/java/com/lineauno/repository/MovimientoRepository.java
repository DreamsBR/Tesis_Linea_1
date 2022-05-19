package com.lineauno.repository;

import com.lineauno.entity.Movimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Integer> {
}
