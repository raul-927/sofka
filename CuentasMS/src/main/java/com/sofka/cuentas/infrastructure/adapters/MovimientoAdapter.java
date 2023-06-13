package com.sofka.cuentas.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.domain.ports.out.MovimientoOut;
import com.sofka.cuentas.infrastructure.repository.MovimientoRepository;
import com.sofka.cuentas.infrastructure.rest.mappers.MovimientoMapper;

@Component
public class MovimientoAdapter implements MovimientoOut {
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	
	@Autowired
	private MovimientoMapper movimientoMapper;

	@Override
	public Movimiento createMovimiento(Movimiento movimiento) {
		var movimientoEntity = movimientoMapper.toMovimientoEnity(movimiento);
		
		return movimientoMapper.toMovimiento(movimientoRepository.save(movimientoEntity));
		
	}

	@Override
	public boolean deleteMovimiento(Movimiento movimiento) {
		
		return false;
	}

	@Override
	public List<Movimiento> selectAllMovimientos() {
		
		return null;
	}

	@Override
	public Movimiento selectMovimiemto(Movimiento movimiento) {
		
		return null;
	}

	@Override
	public Movimiento updateMovimiento(Movimiento movimiento) {
		
		return null;
	}

	@Override
	public List<Movimiento> findMovimientoByFechaAndCliente(int identificacion, String fechaInicial, String fechaFinal) {
		
		var movimientosEntity = movimientoRepository.findMovimientoByFechaAndCliente(identificacion, fechaInicial, fechaFinal);
		
		return (List<Movimiento>) movimientoMapper.toMovimientos(movimientosEntity);
	}

	@Override
	public Movimiento findMovimientoByLastId() {
		var movimientosEntity = movimientoRepository.findMovimientoByLastId();
		
		return movimientoMapper.toMovimiento(movimientosEntity);
	}

}
