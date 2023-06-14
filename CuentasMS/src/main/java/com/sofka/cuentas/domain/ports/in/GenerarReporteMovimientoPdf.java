package com.sofka.cuentas.domain.ports.in;


import java.io.ByteArrayInputStream;
import java.util.List;

import com.sofka.cuentas.domain.models.Movimiento;

public interface GenerarReporteMovimientoPdf {
	
	ByteArrayInputStream movimientoReporte(List<Movimiento>movimientos);

}
