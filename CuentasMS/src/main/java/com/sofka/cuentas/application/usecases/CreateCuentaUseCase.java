package com.sofka.cuentas.application.usecases;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.domain.ports.in.CreateCuentaIn;
import com.sofka.cuentas.domain.ports.out.CuentaOut;


@Component
public class CreateCuentaUseCase implements CreateCuentaIn {

	private final CuentaOut cuentaOut;
	public CreateCuentaUseCase(CuentaOut cuentaOut) {
		this.cuentaOut = cuentaOut;
	}
	
	
	@Override
	public Cuenta createCuenta(Cuenta cuenta) {
		Random nroAleatorio = new Random(System.currentTimeMillis());
		int aux = nroAleatorio.nextInt();
		long nro = 0;
		if(aux<0) {
			nro = (long)aux*(-1);
		}else {
			nro = (long)aux;
		}
		
		cuenta.setNroCuenta(nro);
		
		return cuentaOut.createCuenta(cuenta);
	}

}
