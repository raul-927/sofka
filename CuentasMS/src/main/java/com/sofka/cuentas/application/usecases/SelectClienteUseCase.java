package com.sofka.cuentas.application.usecases;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Cliente;
import com.sofka.cuentas.domain.ports.in.SelectClienteIn;
import com.sofka.cuentas.domain.ports.out.ClienteOut;

@Component
public class SelectClienteUseCase implements SelectClienteIn {
	
	private final ClienteOut clienteOut;
	
	
	public SelectClienteUseCase(ClienteOut clienteOut) {
		this.clienteOut = clienteOut;
	}

	@Override
	public List<Cliente> selectAllClientes() {
		
		return clienteOut.selectAllClientes();
	}

}
