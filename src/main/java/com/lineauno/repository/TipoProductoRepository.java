package com.lineauno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer> {


}
