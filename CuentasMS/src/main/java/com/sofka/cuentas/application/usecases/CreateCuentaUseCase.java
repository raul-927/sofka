package com.sofka.cuentas.application.usecases;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.domain.ports.in.CreateCuentaIn;
import com.sofka.cuentas.domain.ports.out.CuentaOut;


@Component
public class CreateCuentaUseCase implements CreateCuentaIn {

	private final CuentaOut cuentaOut;
	public CreateCuentaUseCase(CuentaOut cuentaOut) {
		this.cuentaOut = cuentaOut;
	}
	
	
	@Override
	public Cuenta createCuenta(Cuenta cuenta) {
		
		return cuentaOut.createCuenta(cuenta);
	}

}
