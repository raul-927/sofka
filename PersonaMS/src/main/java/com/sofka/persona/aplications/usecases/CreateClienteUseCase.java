package com.sofka.persona.aplications.usecases;

import org.springframework.stereotype.Component;

import com.sofka.persona.domain.models.Cliente;
import com.sofka.persona.domain.ports.in.CreateClienteIn;
import com.sofka.persona.domain.ports.out.ClienteOut;


@Component
public class CreateClienteUseCase implements CreateClienteIn {
	
	private final ClienteOut clienteOut;
	
	public CreateClienteUseCase(ClienteOut clienteOut) {
		this.clienteOut = clienteOut;
	}

	@Override
	public Cliente createCliente(Cliente cliente) {
		
		return clienteOut.createCliente(cliente);
	}


}
