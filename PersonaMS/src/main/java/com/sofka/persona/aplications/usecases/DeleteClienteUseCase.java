package com.sofka.persona.aplications.usecases;

import org.springframework.stereotype.Component;

import com.sofka.persona.domain.ports.in.DeleteClienteIn;
import com.sofka.persona.domain.ports.out.ClienteOut;


@Component
public class DeleteClienteUseCase implements DeleteClienteIn{
	
	private final ClienteOut clienteOut;
	
	
	public DeleteClienteUseCase(ClienteOut clienteOut) {
		this.clienteOut = clienteOut;
	}

	@Override
	public boolean deleteCliente(Long clienteId) {
		
		return clienteOut.deleteCliente(clienteId);
	}

}
