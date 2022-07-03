package com.lineauno.service;

import com.lineauno.entity.Usuario;
import com.lineauno.repository.UsuarioRepository;
import com.lineauno.utils.GenericResponse;
import com.lineauno.utils.Globals;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    	
	private final UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	//iniciar sesión
	public GenericResponse<Usuario> login(String email, String clave){
		Optional<Usuario> optionalU = this.repository.login(email, clave);
		if (optionalU.isPresent()) {
			return new GenericResponse<Usuario>(Globals.TIPO_AUTH, Globals.RPTA_OK, "Se inició sesión correctamente", optionalU.get());
		}
		else {
			return new GenericResponse<Usuario>(Globals.TIPO_AUTH, Globals.RPTA_WARNING, "El usuario no existe", new Usuario());
		}
	}
	
	//guardar credenciales del usuario
	public GenericResponse guardarUsuario(Usuario usuario) {
		Optional<Usuario> optionalU = this.repository.findById(usuario.getId());
		int id = optionalU.isPresent() ? optionalU.get().getId() : 0;
		if (id == 0) {
			return new GenericResponse(Globals.TIPO_DATA, Globals.RPTA_OK, "Usuario registrado correctamente", this.repository.save(usuario));	
		}
		else {
			return new GenericResponse(Globals.TIPO_DATA, Globals.RPTA_OK, "Datos del usuario actualizados", this.repository.save(usuario));
		}		
	}

	public Usuario listarPorId(int id) {
		return repository.findById(id).get();
	}


}
