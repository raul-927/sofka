package com.sofka.cuentas.application.usecases;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.domain.ports.in.SelectMovimientoIn;
import com.sofka.cuentas.domain.ports.out.MovimientoOut;


@Component
public class SelectMovimientoUseCase implements SelectMovimientoIn {
	
	private final MovimientoOut movimientoOut;
	
	SelectMovimientoUseCase(MovimientoOut movimientoOut){
		this.movimientoOut = movimientoOut;
	}

	@Override
	public List<Movimiento> selectAllMovimientos() {
		
		return movimientoOut.selectAllMovimientos();
	}

	@Override
	public Movimiento selectMovimiemto(Movimiento movimiento) {
		
		return movimientoOut.selectMovimiemto(movimiento);
	}

	@Override
	public List<Movimiento> findMovimientoByFechaAndCliente(int identificacion, String fechaInicial, String fechaFinal) {
		
		return movimientoOut.findMovimientoByFechaAndCliente(identificacion, fechaInicial, fechaFinal);
	}

}
