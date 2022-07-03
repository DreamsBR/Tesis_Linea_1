package com.lineauno.repository;

import com.lineauno.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {

    @Query("SELECT U FROM Usuario U WHERE U.email=:email AND U.clave=:clave")
	Optional<Usuario> login(String email, String clave);

}
