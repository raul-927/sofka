package com.sofka.persona.domain.ports.out;

import java.util.List;
import com.sofka.persona.domain.models.Cliente;

public interface ClienteOut {
	
	Cliente createCliente(Cliente cliente);
	Cliente updateCliente(Cliente cliente);
	boolean deleteCliente(Long clienteId);
	List <Cliente>selectAllClientes();
	Cliente selectClienteByClienteId(Long clienteId);

}
