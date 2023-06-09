package com.sofka.cuentas.application.usecases;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.domain.ports.in.DeleteCuentaIn;
import com.sofka.cuentas.domain.ports.out.CuentaOut;

@Component
public class DeleteCuentaUseCase implements DeleteCuentaIn {

	private final CuentaOut cuentaOut;
	
	public DeleteCuentaUseCase(CuentaOut cuentaOut) {
		this.cuentaOut = cuentaOut;
	}
	
	@Override
	public boolean deleteCuenta(Cuenta cuenta) {
		
		return cuentaOut.deleteCuenta(cuenta);
	}

}
