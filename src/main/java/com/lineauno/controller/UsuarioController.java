package com.lineauno.controller;

import com.lineauno.dto.UsuarioDTO;
import com.lineauno.entity.Usuario;
import com.lineauno.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") Integer id, @RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.update(id, usuario), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        usuarioService.delete(id);
    }


    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> getPersonaDni(@PathVariable("dni") Integer dni) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ResponseEntity<?> responseEntity = restTemplate.getForEntity("https://api.apis.net.pe/v1/dni?numero=" + dni, UsuarioDTO.class);
        return new ResponseEntity<>(responseEntity.getBody(),HttpStatus.OK);
    }
}
