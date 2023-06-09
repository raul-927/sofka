package com.sofka.cuentas.domain.ports.in;

import com.sofka.cuentas.domain.models.Cuenta;

public interface UpdateCuentaIn {
	
	Cuenta updateCuenta(Cuenta cuenta);

}
