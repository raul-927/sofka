package com.sofka.cuentas.domain.ports.in;

import java.util.List;

import com.sofka.cuentas.domain.models.Cuenta;

public interface SelectCuentaIn {
	
	List<Cuenta>selectAllCuentas();
	Cuenta selectCuenta(Cuenta cuenta);
}
