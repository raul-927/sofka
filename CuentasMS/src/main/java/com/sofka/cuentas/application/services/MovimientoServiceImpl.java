package com.sofka.cuentas.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.domain.ports.in.CreateMovimientoIn;
import com.sofka.cuentas.domain.ports.in.DeleteMovimientoIn;
import com.sofka.cuentas.domain.ports.in.SelectMovimientoIn;
import com.sofka.cuentas.domain.ports.in.UpdateMovimientoIn;

@Service
public class MovimientoServiceImpl implements MovimientoService {
	
	private final CreateMovimientoIn createMovimientoIn;
	private final DeleteMovimientoIn deleteMovimientoIn;
	private final UpdateMovimientoIn updateMovimientoIn;
	private final SelectMovimientoIn selectMovimientoIn;
	
	

	public MovimientoServiceImpl(CreateMovimientoIn createMovimientoIn, DeleteMovimientoIn deleteMovimientoIn,
			UpdateMovimientoIn updateMovimientoIn, SelectMovimientoIn selectMovimientoIn) {
		super();
		this.createMovimientoIn = createMovimientoIn;
		this.deleteMovimientoIn = deleteMovimientoIn;
		this.updateMovimientoIn = updateMovimientoIn;
		this.selectMovimientoIn = selectMovimientoIn;
	}

	@Override
	public Movimiento createMovimiento(Movimiento movimientio) {
		
		return createMovimientoIn.createMovimiento(movimientio);
	}

	@Override
	public boolean deleteMovimiento(Movimiento movimiento) {
		
		return deleteMovimientoIn.deleteMovimiento(movimiento);
	}

	@Override
	public Movimiento updateMovimiento(Movimiento movimiento) {
		
		return updateMovimientoIn.updateMovimiento(movimiento);
	}

	@Override
	public List<Movimiento> selectAllMovimientos() {
		
		return selectMovimientoIn.selectAllMovimientos();
	}

	@Override
	public Movimiento selectMovimiemto(Movimiento movimiento) {
		
		return selectMovimientoIn.selectMovimiemto(movimiento);
	}

	@Override
	public List<Movimiento> findMovimientoByFechaAndCliente(String fechaInicial, String fechaFinal, int identificacion) {
		
		return selectMovimientoIn.findMovimientoByFechaAndCliente(fechaInicial, fechaFinal, identificacion);
	}

}
