package com.sofka.cuentas.application.usecases;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.domain.ports.in.UpdateMovimientoIn;
import com.sofka.cuentas.domain.ports.out.MovimientoOut;

@Component
public class UpdateMovimientoUseCase implements UpdateMovimientoIn {

	private final MovimientoOut movimientoOut;
	
	public UpdateMovimientoUseCase(MovimientoOut movimientoOut) {
		this.movimientoOut = movimientoOut;
	}

	@Override
	public Movimiento updateMovimiento(Movimiento movimiento) {
		
		return movimientoOut.updateMovimiento(movimiento);
	}

}
