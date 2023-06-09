package com.sofka.cuentas.infrastructure.rest.controllers;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.cuentas.application.services.MovimientoService;
import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.infrastructure.exceptions.MovimientoException;

@RestController
@RequestMapping("/movimientos")
@CrossOrigin(origins = "*")
public class MovimientosController {
	
	private final MovimientoService movimientoService;
	
	
	public MovimientosController(MovimientoService movimientoService) {
		this.movimientoService = movimientoService;
	}
	
	@PostMapping
	public ResponseEntity<?> createMovimiento(@RequestBody Movimiento movimiento) throws MovimientoException{
		HttpHeaders header = new HttpHeaders(); 
		try {
			var movimientoResult = movimientoService.createMovimiento(movimiento);
			return new ResponseEntity<Movimiento>(movimientoResult, header, HttpStatus.CREATED);
		}
		catch(MovimientoException ex) {
			return new ResponseEntity<>(new MovimientoException(ex.getMessage()).getMessage(), null, HttpStatus.OK);
		}
		
	}
	
	@GetMapping
	public ResponseEntity<?> findMovimientosByFechaAndCliente(@RequestParam int identificacion, @RequestParam String fechaInicial, @RequestParam String fechaFinal){
		HttpHeaders header = new HttpHeaders(); 
		try {
			var movimientoResult = movimientoService.findMovimientoByFechaAndCliente(identificacion, fechaInicial, fechaFinal);
			return new ResponseEntity<List<Movimiento>>(movimientoResult, header, HttpStatus.CREATED);
		}
		catch(MovimientoException ex) {
			return new ResponseEntity<>(new MovimientoException(ex.getMessage()).getMessage(), null, HttpStatus.OK);
		}
	}
	
	
	@GetMapping(value ="/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource>generarPdf(@RequestParam(name="identificacion")int identificacion,
			@RequestParam(name="fechaInicial") String fechaInicial, 
			@RequestParam(name="fechaFinal")String fechaFinal){
		HttpHeaders headers = new HttpHeaders();
		
		List<Movimiento> movimientoResult = movimientoService.findMovimientoByFechaAndCliente(identificacion, fechaInicial, fechaFinal);
		ByteArrayInputStream in = movimientoService.movimientoReporte(movimientoResult);
		InputStreamResource reporte = new InputStreamResource(in);
		return new ResponseEntity<>(reporte, headers, HttpStatus.CREATED);
		
	}
	

}
