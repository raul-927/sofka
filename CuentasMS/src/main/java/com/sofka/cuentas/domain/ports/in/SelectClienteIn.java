package com.sofka.cuentas.domain.ports.in;

import java.util.List;

import com.sofka.cuentas.domain.models.Cliente;

public interface SelectClienteIn {
	
	List<Cliente> selectAllClientes();

}
