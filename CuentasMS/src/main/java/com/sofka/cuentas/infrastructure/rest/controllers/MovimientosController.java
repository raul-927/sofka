package com.sofka.cuentas.infrastructure.rest.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.cuentas.application.services.MovimientoService;
import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.domain.models.Movimiento;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {
	
	private final MovimientoService movimientoService;
	
	
	public MovimientosController(MovimientoService movimientoService) {
		this.movimientoService = movimientoService;
	}
	
	@PostMapping
	public ResponseEntity<Movimiento> createMovimiento(@RequestBody Movimiento movimiento){
		HttpHeaders header = new HttpHeaders(); 
		var movimientoResult = movimientoService.createMovimiento(movimiento);
		
		return new ResponseEntity<Movimiento>(movimientoResult, header, HttpStatus.CREATED);
	}
	
	

}
