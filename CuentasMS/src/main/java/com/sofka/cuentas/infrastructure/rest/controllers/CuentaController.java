package com.sofka.cuentas.infrastructure.rest.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.cuentas.application.services.CuentaService;
import com.sofka.cuentas.domain.models.Cuenta;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
	
	
	private final CuentaService cuentaService;
	
	
	public CuentaController(CuentaService cuentaService) {
		this.cuentaService = cuentaService;
	}
	
	
	@PostMapping
	public ResponseEntity<Cuenta> insertCuenta(@RequestBody Cuenta cuenta){
		HttpHeaders header = new HttpHeaders(); 
		var cuentaResult = cuentaService.createCuenta(cuenta);
		
		return new ResponseEntity<Cuenta>(cuentaResult, header, HttpStatus.CREATED);
	}
	
	@PatchMapping
	public ResponseEntity<Cuenta> updateCuenta(@RequestBody Cuenta cuenta){
		HttpHeaders header = new HttpHeaders(); 
		var cuentaResult = cuentaService.updateCuenta(cuenta);
		return new ResponseEntity<Cuenta>(cuentaResult, header, HttpStatus.CREATED);
	}
	

}
