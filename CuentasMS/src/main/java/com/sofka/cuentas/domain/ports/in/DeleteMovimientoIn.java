package com.sofka.cuentas.domain.ports.in;

import com.sofka.cuentas.domain.models.Movimiento;

public interface DeleteMovimientoIn {
	
	boolean deleteMovimiento(Movimiento movimiento);

}
