package com.sofka.persona.aplications.services;

import java.util.List;
import java.util.Map;

import com.sofka.persona.domain.models.Cliente;

import com.sofka.persona.domain.ports.in.CreateClienteIn;
import com.sofka.persona.domain.ports.in.DeleteClienteIn;
import com.sofka.persona.domain.ports.in.SelectClienteIn;
import com.sofka.persona.domain.ports.in.UpdateClienteIn;

public class ClienteServiceImpl implements ClienteService {
	
	private final CreateClienteIn createClienteIn;
	private final UpdateClienteIn updateClienteIn;
	private final DeleteClienteIn deleteClienteIn;
	private final SelectClienteIn selectClienteIn;
	
	public ClienteServiceImpl(CreateClienteIn createClienteIn, UpdateClienteIn updateClienteIn, DeleteClienteIn deleteClienteIn, 
			SelectClienteIn selectClienteIn) {
		this.createClienteIn = createClienteIn;
		this.updateClienteIn = updateClienteIn;
		this.deleteClienteIn = deleteClienteIn;
		this.selectClienteIn = selectClienteIn;
	}

	@Override
	public boolean deleteCliente(Long clienteId) {
		
		return deleteClienteIn.deleteCliente(clienteId);
	}


	@Override
	public List<Cliente> selectAllClientes() {
	
		return selectClienteIn.selectAllClientes();
	}

	@Override
	public Cliente selectClienteByClienteId(Long clienteId) {
		
		return selectClienteIn.selectClienteByClienteId(clienteId);
	}


	@Override
	public Cliente createCliente(Cliente cliente) {
		return createClienteIn.createCliente(cliente);
	}


	@Override
	public Cliente updateCliente(Cliente cliente) {
		return updateClienteIn.updateCliente(cliente);
	}


}
