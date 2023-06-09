package com.sofka.cuentas.domain.ports.out;

import java.util.List;

import com.sofka.cuentas.domain.models.Movimiento;

public interface MovimientoOut {
	Movimiento createMovimiento(Movimiento movimientio);
	boolean deleteMovimiento(Movimiento movimiento);
	List<Movimiento>selectAllMovimientos();
	Movimiento selectMovimiemto(Movimiento movimiento);
	Movimiento updateMovimiento(Movimiento movimiento);
}
