package com.sofka.persona.domain.ports.in;

import java.util.List;

import com.sofka.persona.domain.models.Cliente;

public interface SelectClienteIn {
	
	List<Cliente>selectAllClientes();
	Cliente selectClienteByClienteId(Long clienteId);

}
