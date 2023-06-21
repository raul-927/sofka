package com.sofka.cuentas.infrastructure.rest.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.cuentas.application.services.ClienteService;
import com.sofka.cuentas.domain.models.Cliente;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
	
	
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAllClientes(){
		HttpHeaders header = new HttpHeaders(); 
		var clienteResult = clienteService.selectAllClientes();
		return new ResponseEntity<List<Cliente>>(clienteResult, header, HttpStatus.OK);
	}
	

}
