package com.sofka.cuentas.application.services;

import com.sofka.cuentas.domain.ports.in.CreateMovimientoIn;
import com.sofka.cuentas.domain.ports.in.DeleteMovimientoIn;
import com.sofka.cuentas.domain.ports.in.GenerarReporteMovimientoPdf;
import com.sofka.cuentas.domain.ports.in.SelectMovimientoIn;
import com.sofka.cuentas.domain.ports.in.UpdateMovimientoIn;

public interface MovimientoService
		extends CreateMovimientoIn, DeleteMovimientoIn, UpdateMovimientoIn, SelectMovimientoIn, GenerarReporteMovimientoPdf {

}
