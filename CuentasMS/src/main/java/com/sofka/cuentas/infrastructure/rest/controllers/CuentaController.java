package com.sofka.cuentas.infrastructure.rest.controllers;

import java.util.List;

import javax.activation.MimeType;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.cuentas.application.services.CuentaService;
import com.sofka.cuentas.domain.models.Cuenta;

@RestController
@RequestMapping("/cuentas")
@CrossOrigin(origins = "*")
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
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Cuenta> updateCuenta(@RequestBody Cuenta cuenta){
		HttpHeaders header = new HttpHeaders(); 
		var cuentaResult = cuentaService.updateCuenta(cuenta);
		return new ResponseEntity<Cuenta>(cuentaResult, header, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cuenta>>findAllCuentas(){
		HttpHeaders header = new HttpHeaders(); 
		var cuentaResult = cuentaService.selectAllCuentas();
		return new ResponseEntity<List<Cuenta>>(cuentaResult, header, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{cuentaId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean>deleteCuenta(@PathVariable int cuentaId){
		HttpHeaders header = new HttpHeaders();
		Cuenta cuenta = new Cuenta();
		cuenta.setCuentaId(Integer.toUnsignedLong(cuentaId));
		var cuentaResult = cuentaService.deleteCuenta(cuenta);
		return new ResponseEntity<Boolean>(cuentaResult, header, HttpStatus.OK);
	}
	

}
