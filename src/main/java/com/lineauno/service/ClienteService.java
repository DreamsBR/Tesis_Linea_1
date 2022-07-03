package com.lineauno.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.lineauno.entity.Cliente;
import com.lineauno.repository.ClienteRepository;
import com.lineauno.utils.GenericResponse;
import com.lineauno.utils.Globals;

@Service
@Transactional
public class ClienteService {

	private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }
    
    //guardar y actualizar
    public GenericResponse guardar(Cliente cliente) {
    	Optional<Cliente> optCliente = this.repository.findById(cliente.getId());
    	int id = optCliente.isPresent() ? optCliente.get().getId() : 0;
    	if (id == 0) {
			if (repository.existByDoc(cliente.getNumero_documento().trim()) == 1) { //verificar si existe el cliente
				return new GenericResponse(Globals.TIPO_RESULT, Globals.RPTA_WARNING, "Número de documento ya está registrado ", null);
			}else {//guardar nuevo cliente
				cliente.setId(id);
				return new GenericResponse(Globals.TIPO_DATA, Globals.RPTA_OK, "Cliente registrado correctamente", this.repository.save(cliente));
			}
		}else {
			//actualizar registro
			if(repository.existByDocForUpdate(cliente.getNumero_documento().trim(), cliente.getId()) == 1){
                return new GenericResponse(Globals.TIPO_RESULT, Globals.RPTA_WARNING, "Ya existe un cliente con esos mismos datos", null);
            }else{
                //Actualiza cliente
                cliente.setId(id);
                return new GenericResponse(Globals.TIPO_DATA, Globals.RPTA_OK, "Datos del cliente actualizado", this.repository.save(cliente));
            }
		}
    }

	public List<Cliente> listar() {
		return (List<Cliente>) repository.findAll();
	}

	public Cliente buscarPorId(int id) {
		return repository.findById(id).get();
	}

	//delete client
	public GenericResponse eliminar(int id) {
		repository.deleteById(id);
		return new GenericResponse(Globals.TIPO_RESULT, Globals.RPTA_OK, "Cliente eliminado correctamente", null);
	}
    
}
