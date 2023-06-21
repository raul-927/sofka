package com.sofka.cuentas.domain.ports.out;

import java.util.List;

import com.sofka.cuentas.domain.models.Cliente;

public interface ClienteOut {
	List<Cliente> selectAllClientes();
}
