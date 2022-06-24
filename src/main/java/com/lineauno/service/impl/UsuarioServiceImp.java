package com.lineauno.service.impl;

import com.lineauno.entity.Usuario;
import com.lineauno.repository.UsuarioRepository;
import com.lineauno.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Integer id, Usuario usuario) {
        Usuario objUsuario = usuarioRepository.findById(id).get();
        objUsuario.setNombres(usuario.getNombres());
        objUsuario.setApellidos(usuario.getApellidos());
        objUsuario.setTipo_documento(usuario.getTipo_documento());
        objUsuario.setNumero_documento(usuario.getNumero_documento());
        objUsuario.setEmail(usuario.getEmail());
        return usuarioRepository.save(objUsuario);
    }

    @Override
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
