package com.lineauno.repository;

import com.lineauno.entity.Movimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Integer> {

    @Query(value = "select * from movimientos where email = :email order by id_movimiento desc limit 5", nativeQuery = true)
    Iterable<Movimiento> getLastFiveMovements(@Param("email") String email);
}
