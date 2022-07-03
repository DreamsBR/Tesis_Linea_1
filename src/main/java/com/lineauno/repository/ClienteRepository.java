package com.lineauno.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lineauno.entity.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    
	@Query(value = "(SELECT EXISTS(SELECT id FROM clientes WHERE numero_documento=:numero_documento))", nativeQuery = true)
    int existByDoc(String numero_documento);

    @Query(value = "SELECT EXISTS(SELECT U.* FROM clientes U WHERE U.numero_documento=:numero_documento AND NOT (U.id=:id))", nativeQuery = true)
    int existByDocForUpdate(String numero_documento, int id);
    
}