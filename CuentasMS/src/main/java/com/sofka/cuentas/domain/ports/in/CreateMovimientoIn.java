package com.sofka.cuentas.domain.ports.in;

import com.sofka.cuentas.domain.models.Movimiento;

public interface CreateMovimientoIn {
	
	Movimiento createMovimiento(Movimiento movimientio);

}
