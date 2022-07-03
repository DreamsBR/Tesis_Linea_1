package com.lineauno.controller;

import java.util.Arrays;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lineauno.dto.UsuarioDTO;

@RestController
@RequestMapping("/api/v1")
public class DniController {
    
    @Autowired
	RestTemplate restTemplate;


    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> getPersonaDni(@PathVariable("dni") Integer dni) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ResponseEntity<?> responseEntity = restTemplate.getForEntity("https://api.apis.net.pe/v1/dni?numero=" + dni, UsuarioDTO.class);
        return new ResponseEntity<>(responseEntity.getBody(),HttpStatus.OK);
    }

	//buscar persona por dni
	@GetMapping("/{dni}")
	public String getPersonaDni(@PathVariable("dni") int dni) {
		System.out.println("Dentro del método getPersonaDni");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange("https://api.apis.net.pe/v1/dni?numero=" + dni,
				HttpMethod.GET, entity, String.class);
		return responseEntity.getBody();
	}
}
