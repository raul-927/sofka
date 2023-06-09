package com.sofka.cuentas.application.usecases;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.domain.ports.in.DeleteMovimientoIn;
import com.sofka.cuentas.domain.ports.out.MovimientoOut;

@Component
public class DeleteMovimientoUseCase implements DeleteMovimientoIn {

	private final MovimientoOut movimientoOut;
	public DeleteMovimientoUseCase(MovimientoOut movimientoOut) {
		this.movimientoOut = movimientoOut;
	}
	
	@Override
	public boolean deleteMovimiento(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return movimientoOut.deleteMovimiento(movimiento);
	}

}
