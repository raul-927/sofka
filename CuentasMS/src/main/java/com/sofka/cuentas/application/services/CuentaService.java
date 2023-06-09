package com.sofka.cuentas.application.services;

import com.sofka.cuentas.domain.ports.in.CreateCuentaIn;
import com.sofka.cuentas.domain.ports.in.DeleteCuentaIn;
import com.sofka.cuentas.domain.ports.in.SelectCuentaIn;
import com.sofka.cuentas.domain.ports.in.UpdateCuentaIn;

public interface CuentaService extends CreateCuentaIn, DeleteCuentaIn, UpdateCuentaIn, SelectCuentaIn {

}
