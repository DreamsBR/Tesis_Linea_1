package com.lineauno.repository;

import com.lineauno.entity.Movimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Integer> {

    @Query(value = "select * from movimientos order by id_movimiento desc limit 5", nativeQuery = true)
    List<Movimiento> getLastFiveMovements();

}
