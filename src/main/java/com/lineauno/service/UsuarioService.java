package com.lineauno.service;


import com.lineauno.entity.Movimiento;
import com.lineauno.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(Integer id);
    Usuario save(Usuario usuario);
    Usuario update(Integer id, Usuario usuario);
    void delete(Integer id);
}
