package com.sofka.cuentas.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sofka.cuentas.domain.models.Cliente;
import com.sofka.cuentas.domain.ports.in.SelectClienteIn;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private final SelectClienteIn selectClienteIn;
	
	public ClienteServiceImpl(SelectClienteIn selectClienteIn) {
		this.selectClienteIn = selectClienteIn;
	}

	@Override
	public List<Cliente> selectAllClientes() {
		return selectClienteIn.selectAllClientes();
	}

}
