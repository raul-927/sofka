package com.sofka.cuentas.infrastructure.adapters;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.domain.ports.out.MovimientoOut;

@Component
public class MovimientoAdapter implements MovimientoOut {

	@Override
	public Movimiento createMovimiento(Movimiento movimientio) {
		
		return null;
	}

	@Override
	public boolean deleteMovimiento(Movimiento movimiento) {
		
		return false;
	}

	@Override
	public List<Movimiento> selectAllMovimientos() {
		
		return null;
	}

	@Override
	public Movimiento selectMovimiemto(Movimiento movimiento) {
		
		return null;
	}

	@Override
	public Movimiento updateMovimiento(Movimiento movimiento) {
		
		return null;
	}

}
