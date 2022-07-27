package com.lineauno.repository;

import com.lineauno.entity.Tarjeta;
import com.lineauno.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarjetaRepository  extends CrudRepository<Tarjeta,Integer> {

    @Query(value = "select * from tarjetas where cliente_id = :id", nativeQuery = true)
    Optional<Tarjeta> getTarjetaUsuario(int id);

}
