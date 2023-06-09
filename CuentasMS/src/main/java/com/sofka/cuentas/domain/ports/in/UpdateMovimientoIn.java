package com.sofka.cuentas.domain.ports.in;

import com.sofka.cuentas.domain.models.Movimiento;

public interface UpdateMovimientoIn {
	
	Movimiento updateMovimiento(Movimiento movimiento);

}
