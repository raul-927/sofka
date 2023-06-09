package com.sofka.cuentas.application.usecases;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.domain.ports.in.CreateMovimientoIn;
import com.sofka.cuentas.domain.ports.out.CuentaOut;
import com.sofka.cuentas.domain.ports.out.MovimientoOut;
import com.sofka.cuentas.infrastructure.exceptions.MovimientoException;

@Component
public class CreateMovimientoUseCase implements CreateMovimientoIn {
	
	private final CuentaOut cuentaOut;

	private final MovimientoOut movimientoOut;
	
	public CreateMovimientoUseCase(MovimientoOut movimientoOut, CuentaOut cuentaOut) {
		this.movimientoOut = movimientoOut;
		this.cuentaOut = cuentaOut;
	}
	
	@Override
	public Movimiento createMovimiento(Movimiento movimiento) throws MovimientoException{
		var cuenta = cuentaOut.selectCuenta(movimiento.getCuenta());
		LocalDate fechaHoy = LocalDate.now();
		
		movimiento.setFecha(fechaHoy);
		if(cuenta.getSaldoInicial().compareTo(movimiento.getValor())< 0) {
			throw new MovimientoException("Saldo insuficiente");
		}
		cuenta.setSaldoInicial(cuenta.getSaldoInicial().subtract(movimiento.getValor()));
		cuentaOut.updateCuenta(cuenta);
		return movimientoOut.createMovimiento(movimiento);
		
	}

}
