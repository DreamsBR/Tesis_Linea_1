package com.lineauno.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lineauno.entity.Usuario;
import com.lineauno.service.UsuarioService;
import com.lineauno.utils.GenericResponse;


@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

	private final UsuarioService service;

	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	@PostMapping("/login")
	public GenericResponse<Usuario> login(HttpServletRequest request){
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		return this.service.login(email, clave);
	}
	
	@PostMapping
	public GenericResponse<Usuario> guardar(@RequestBody Usuario usuario){
		return this.service.guardarUsuario(usuario);
	}
	
	@PutMapping("/{id}")
	public GenericResponse<Usuario> actualizar(@PathVariable("id") int id,@RequestBody Usuario usuario){
		return this.service.guardarUsuario(usuario);
	}
}
