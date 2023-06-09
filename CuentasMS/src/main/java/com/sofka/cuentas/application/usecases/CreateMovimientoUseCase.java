package com.sofka.cuentas.application.usecases;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.domain.ports.in.CreateMovimientoIn;
import com.sofka.cuentas.domain.ports.out.MovimientoOut;

@Component
public class CreateMovimientoUseCase implements CreateMovimientoIn {

	private final MovimientoOut movimientoOut;
	
	public CreateMovimientoUseCase(MovimientoOut movimientoOut) {
		this.movimientoOut = movimientoOut;
	}
	
	@Override
	public Movimiento createMovimiento(Movimiento movimientio) {
		
		return movimientoOut.createMovimiento(movimientio);
	}

}
