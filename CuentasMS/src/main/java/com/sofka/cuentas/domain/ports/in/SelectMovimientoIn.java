package com.sofka.cuentas.domain.ports.in;

import java.util.List;

import com.sofka.cuentas.domain.models.Movimiento;

public interface SelectMovimientoIn {
	
	List<Movimiento>selectAllMovimientos();
	Movimiento selectMovimiemto(Movimiento movimiento);
	List<Movimiento> findMovimientoByFechaAndCliente(int identificacion, String fechaInicial, String fechaFinal);
}
