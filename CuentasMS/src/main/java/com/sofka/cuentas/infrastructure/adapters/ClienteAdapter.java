package com.sofka.cuentas.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Cliente;
import com.sofka.cuentas.domain.ports.out.ClienteOut;
import com.sofka.cuentas.infrastructure.entitys.ClienteViewEntity;
import com.sofka.cuentas.infrastructure.repository.ClienteRepository;
import com.sofka.cuentas.infrastructure.rest.mappers.ClienteMapper;


@Component
public class ClienteAdapter implements ClienteOut {
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteMapper clienteMapper;

	@Override
	public List<Cliente> selectAllClientes() {
		var clientes = clienteMapper.toclientes(clienteRepository.findAll());
		
		return (List<Cliente>) clientes;
	}

}
