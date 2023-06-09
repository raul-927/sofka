package com.sofka.persona.aplications.usecases;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sofka.persona.domain.models.Cliente;
import com.sofka.persona.domain.ports.in.SelectClienteIn;
import com.sofka.persona.domain.ports.out.ClienteOut;


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

	@Override
	public Cliente selectClienteByClienteId(Long clienteId) {
		
		return clienteOut.selectClienteByClienteId(clienteId);
	}

}
