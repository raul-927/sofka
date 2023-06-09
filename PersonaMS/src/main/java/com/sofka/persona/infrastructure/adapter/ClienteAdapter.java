package com.sofka.persona.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sofka.persona.domain.models.Cliente;
import com.sofka.persona.domain.ports.out.ClienteOut;
import com.sofka.persona.infrastructure.entitys.ClienteEntity;
import com.sofka.persona.infrastructure.exceptions.ClienteException;
import com.sofka.persona.infrastructure.kafka.message.ClienteMessage;
import com.sofka.persona.infrastructure.repository.ClienteRepository;
import com.sofka.persona.infrastructure.rest.mappers.ClienteMapper;


@Component
public class ClienteAdapter implements ClienteOut {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	@Autowired
	private ClienteMessage clienteMessage;
	

	@Override
	public Cliente createCliente(Cliente cliente) {
		var clienteEntity = clienteMapper.toClienteEnity(cliente);
		var clienteResult = 	clienteRepository.save(clienteEntity);
		clienteMessage.sendClienteMessage(clienteResult);
		return clienteMapper.toCliente(clienteResult);
	}

	@Override
	public boolean deleteCliente(Long clienteId) {
		var clienteEntity = clienteRepository.findById(clienteId).orElseThrow(
				() -> new ClienteException("Cliente no encontrado"));
		clienteRepository.delete(clienteEntity);
		return true;
	}
	
	@Override
	public Cliente updateCliente(Cliente cliente) {
		Optional<ClienteEntity> existCliente = clienteRepository.findById(cliente.getClienteId());
		
		if(existCliente.isPresent()) {
			if(cliente.getContrasenia()!=null) {
				existCliente.get().setContrasenia(cliente.getContrasenia());
			}
			if(cliente.getDireccion()!=null) {
				existCliente.get().setDireccion(cliente.getDireccion());
			}
			if(cliente.getEdad()!=null) {
				existCliente.get().setEdad(cliente.getEdad());
			}
			if(cliente.getGenero()!= null) {
				existCliente.get().setGenero(cliente.getGenero());
			}
			if(cliente.getIdentificacion()> 0) {
				existCliente.get().setIdentificacion(cliente.getIdentificacion());
			}
			if(cliente.getNombre()!=null) {
				existCliente.get().setNombre(cliente.getNombre());
			}
			if(cliente.getTelefono()!=null) {
				existCliente.get().setTelefono(cliente.getTelefono());
			}
			var clienteResult = clienteRepository.save(existCliente.get());
			return  clienteMapper.toCliente(clienteResult);
		}
		
		return null;
		
	}

	@Override
	public List<Cliente> selectAllClientes() {
		var cliente = clienteMapper.toClientes(clienteRepository.findAll());
		return (List<Cliente>) cliente;
	}

	@Override
	public Cliente selectClienteByClienteId(Long clienteId) {
		var clienteEntity = clienteRepository.findById(clienteId);
		return clienteMapper.toCliente(clienteEntity.get());
	}

	

}
