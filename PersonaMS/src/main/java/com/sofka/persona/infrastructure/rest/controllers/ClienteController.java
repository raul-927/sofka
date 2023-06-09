package com.sofka.persona.infrastructure.rest.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import com.sofka.persona.aplications.services.ClienteService;
import com.sofka.persona.domain.models.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	
	
	@PostMapping
	public ResponseEntity<Cliente>insertCliente(@RequestBody @Valid Cliente cliente){
		HttpHeaders headers = new HttpHeaders();
		Cliente clienteCreado = clienteService.createCliente(cliente);
		
		return new ResponseEntity<Cliente>(clienteCreado, headers, HttpStatus.CREATED);
	}
	
	@PatchMapping
	public ResponseEntity<Cliente>updateCliente(@RequestBody Cliente cliente){
		HttpHeaders headers = new HttpHeaders();
		Cliente clienteCreado = clienteService.updateCliente(cliente);
		
		return new ResponseEntity<Cliente>(clienteCreado, headers, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping
	public ResponseEntity<Cliente>deleteCliente(@RequestBody @Valid Cliente cliente){
		HttpHeaders headers = new HttpHeaders();
		clienteService.deleteCliente(cliente.getClienteId());
		
		return new ResponseEntity<Cliente>(null, headers, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>>selectAllCliente(){
		HttpHeaders headers = new HttpHeaders();
		
		List<Cliente> clientes = clienteService.selectAllClientes();
		
		return new ResponseEntity<List<Cliente>>(clientes, headers, HttpStatus.CREATED);
	}
	

}
