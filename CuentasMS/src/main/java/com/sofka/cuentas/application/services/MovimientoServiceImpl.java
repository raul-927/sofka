package com.sofka.cuentas.application.services;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.domain.ports.in.CreateMovimientoIn;
import com.sofka.cuentas.domain.ports.in.DeleteMovimientoIn;
import com.sofka.cuentas.domain.ports.in.GenerarReporteMovimientoPdf;
import com.sofka.cuentas.domain.ports.in.SelectMovimientoIn;
import com.sofka.cuentas.domain.ports.in.UpdateMovimientoIn;

@Service
public class MovimientoServiceImpl implements MovimientoService {
	
	private final CreateMovimientoIn createMovimientoIn;
	private final DeleteMovimientoIn deleteMovimientoIn;
	private final UpdateMovimientoIn updateMovimientoIn;
	private final SelectMovimientoIn selectMovimientoIn;
	private final GenerarReporteMovimientoPdf generarReporteMovimientoPdf;
	
	

	public MovimientoServiceImpl(CreateMovimientoIn createMovimientoIn, DeleteMovimientoIn deleteMovimientoIn,
			UpdateMovimientoIn updateMovimientoIn, SelectMovimientoIn selectMovimientoIn,
			GenerarReporteMovimientoPdf generarReporteMovimientoPdf) {
		super();
		this.createMovimientoIn = createMovimientoIn;
		this.deleteMovimientoIn = deleteMovimientoIn;
		this.updateMovimientoIn = updateMovimientoIn;
		this.selectMovimientoIn = selectMovimientoIn;
		this.generarReporteMovimientoPdf = generarReporteMovimientoPdf;
	}

	@Override
	public Movimiento createMovimiento(Movimiento movimientio) {
		
		return createMovimientoIn.createMovimiento(movimientio);
	}

	@Override
	public boolean deleteMovimiento(Movimiento movimiento) {
		
		return deleteMovimientoIn.deleteMovimiento(movimiento);
	}

	@Override
	public Movimiento updateMovimiento(Movimiento movimiento) {
		
		return updateMovimientoIn.updateMovimiento(movimiento);
	}

	@Override
	public List<Movimiento> selectAllMovimientos() {
		
		return selectMovimientoIn.selectAllMovimientos();
	}

	@Override
	public Movimiento selectMovimiemto(Movimiento movimiento) {
		
		return selectMovimientoIn.selectMovimiemto(movimiento);
	}

	@Override
	public List<Movimiento> findMovimientoByFechaAndCliente(int identificacion, String fechaInicial, String fechaFinal) {
		
		return selectMovimientoIn.findMovimientoByFechaAndCliente(identificacion, fechaInicial, fechaFinal);
	}

	@Override
	public ByteArrayInputStream movimientoReporte(List<Movimiento> movimientos) {
		
		return generarReporteMovimientoPdf.movimientoReporte(movimientos);
	}

}
