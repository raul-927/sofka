package com.sofka.cuentas.domain.ports.in;

import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.infrastructure.exceptions.MovimientoException;

public interface CreateMovimientoIn {
	
	Movimiento createMovimiento(Movimiento movimiento) throws MovimientoException;

}
