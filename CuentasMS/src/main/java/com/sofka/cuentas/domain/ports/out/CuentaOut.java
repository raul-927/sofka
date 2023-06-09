package com.sofka.cuentas.domain.ports.out;

import java.util.List;

import com.sofka.cuentas.domain.models.Cuenta;

public interface CuentaOut {
	
	Cuenta createCuenta(Cuenta cuenta);
	boolean deleteCuenta(Cuenta cuenta);
	List<Cuenta>selectAllCuentas();
	Cuenta selectCuenta(Cuenta cuenta);
	Cuenta updateCuenta(Cuenta cuenta);
}
