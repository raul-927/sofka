package com.sofka.persona.domain.ports.in;

import java.util.Map;

import com.sofka.persona.domain.models.Cliente;

public interface UpdateClienteIn {
	
	Cliente updateCliente(Cliente cliente);

}
