package com.sofka.persona.aplications.usecases;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.sofka.persona.domain.models.Cliente;
import com.sofka.persona.domain.ports.in.UpdateClienteIn;
import com.sofka.persona.domain.ports.out.ClienteOut;


@Component
public class UpdateClienteUseCase implements UpdateClienteIn{
	
	private final ClienteOut clienteOut;
	
	public UpdateClienteUseCase(ClienteOut clienteOut) {
		this.clienteOut = clienteOut;
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		
		return clienteOut.updateCliente(cliente);
	}

}
