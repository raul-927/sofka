package com.sofka.cuentas.domain.ports.in;

import com.sofka.cuentas.domain.models.Cuenta;

public interface DeleteCuentaIn {
	
	boolean deleteCuenta(Cuenta cuenta);

}
