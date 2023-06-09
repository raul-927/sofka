package com.sofka.cuentas.application.usecases;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.domain.ports.in.UpdateCuentaIn;
import com.sofka.cuentas.domain.ports.out.CuentaOut;

@Component
public class UpdateCuentaUseCase implements UpdateCuentaIn {
	
	
	private final CuentaOut cuentaOut;
	
	public UpdateCuentaUseCase(CuentaOut cuentaOut) {
		this.cuentaOut = cuentaOut;
	}
	@Override
	public Cuenta updateCuenta(Cuenta cuenta) {
		
		return cuentaOut.updateCuenta(cuenta);
	}

}
