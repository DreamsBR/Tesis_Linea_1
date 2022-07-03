package com.lineauno.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lineauno.entity.Cliente;
import com.lineauno.service.ClienteService;
import com.lineauno.utils.GenericResponse;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public List<Cliente> listar(){
    	return clienteService.listar();
    }

	@PostMapping
	public GenericResponse guardar(@Valid @RequestBody Cliente cliente) {
		return this.clienteService.guardar(cliente);
	}
	
	@PutMapping("/{id}")
	public GenericResponse actualizar(@PathVariable("id") int id, @Valid @RequestBody Cliente cliente) {
		cliente.setId(id);
		return this.clienteService.guardar(cliente);
	}

	// delete by id
	@DeleteMapping("/{id}")
	public GenericResponse eliminar(@PathVariable("id") int id) {
		return this.clienteService.eliminar(id);
	}
}
