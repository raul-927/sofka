package com.sofka.cuentas.application.usecases;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.domain.ports.in.SelectCuentaIn;
import com.sofka.cuentas.domain.ports.out.CuentaOut;

@Component
public class SelectCuentaUseCase implements SelectCuentaIn {

	private final CuentaOut cuentaOut;
	
	public SelectCuentaUseCase(CuentaOut cuentaOut) {
		this.cuentaOut = cuentaOut;
	}
	
	@Override
	public List<Cuenta> selectAllCuentas() {
		
		return cuentaOut.selectAllCuentas();
	}

	@Override
	public Cuenta selectCuenta(Cuenta cuenta) {
		
		return cuentaOut.selectCuenta(cuenta);
	}

}
