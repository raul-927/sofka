package com.sofka.cuentas.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.domain.ports.in.CreateCuentaIn;
import com.sofka.cuentas.domain.ports.in.DeleteCuentaIn;
import com.sofka.cuentas.domain.ports.in.SelectCuentaIn;
import com.sofka.cuentas.domain.ports.in.UpdateCuentaIn;

@Service
public class CuentaServiceImpl implements CuentaService {
	
	private final CreateCuentaIn createCuentaIn;
	private final DeleteCuentaIn deleteCuentaIn;
	private final UpdateCuentaIn updateCuentaIn;
	private final SelectCuentaIn selectCuentaIn;
	
	public CuentaServiceImpl(CreateCuentaIn createCuentaIn, DeleteCuentaIn deleteCuentaIn,
			UpdateCuentaIn updateCuentaIn, SelectCuentaIn selectCuentaIn) {
		this.createCuentaIn = createCuentaIn;
		this.deleteCuentaIn = deleteCuentaIn;
		this.updateCuentaIn = updateCuentaIn;
		this.selectCuentaIn = selectCuentaIn;
	}

	@Override
	public Cuenta createCuenta(Cuenta cuenta) {
		
		return createCuentaIn.createCuenta(cuenta);
	}

	@Override
	public boolean deleteCuenta(Cuenta cuenta) {
		
		return deleteCuentaIn.deleteCuenta(cuenta);
	}

	@Override
	public Cuenta updateCuenta(Cuenta cuenta) {
		
		return updateCuentaIn.updateCuenta(cuenta);
	}

	@Override
	public List<Cuenta> selectAllCuentas() {
		
		return selectCuentaIn.selectAllCuentas();
	}

	@Override
	public Cuenta selectCuenta(Cuenta cuenta) {
		
		return selectCuentaIn.selectCuenta(cuenta);
	}

}
