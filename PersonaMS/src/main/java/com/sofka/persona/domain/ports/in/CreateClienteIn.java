package com.sofka.persona.domain.ports.in;

import com.sofka.persona.domain.models.Cliente;

public interface CreateClienteIn {
	
	Cliente createCliente(Cliente cliente);

}
