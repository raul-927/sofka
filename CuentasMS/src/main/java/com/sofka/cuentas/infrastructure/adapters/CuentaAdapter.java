package com.sofka.cuentas.infrastructure.adapters;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.domain.ports.out.CuentaOut;

@Component
public class CuentaAdapter implements CuentaOut {

	@Override
	public Cuenta createCuenta(Cuenta cuenta) {
		
		return null;
	}

	@Override
	public boolean deleteCuenta(Cuenta cuenta) {
		
		return false;
	}

	@Override
	public List<Cuenta> selectAllCuentas() {
		
		return null;
	}

	@Override
	public Cuenta selectCuenta(Cuenta cuenta) {
		
		return null;
	}

	@Override
	public Cuenta updateCuenta(Cuenta cuenta) {
		
		return null;
	}

}
