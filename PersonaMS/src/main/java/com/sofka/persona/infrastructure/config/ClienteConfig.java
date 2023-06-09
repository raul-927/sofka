package com.sofka.persona.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sofka.persona.aplications.services.ClienteService;
import com.sofka.persona.aplications.services.ClienteServiceImpl;
import com.sofka.persona.domain.ports.in.CreateClienteIn;
import com.sofka.persona.domain.ports.in.DeleteClienteIn;
import com.sofka.persona.domain.ports.in.SelectClienteIn;
import com.sofka.persona.domain.ports.in.UpdateClienteIn;
import com.sofka.persona.domain.ports.out.ClienteOut;
import com.sofka.persona.infrastructure.adapter.ClienteAdapter;

@Configuration

public class ClienteConfig {
	
	
	@Bean
	public ClienteOut clienteOut() {
		return new ClienteAdapter();
	}
	
	@Bean
	public ClienteService clienteService(CreateClienteIn createClienteIn, UpdateClienteIn updateClienteIn, DeleteClienteIn deleteClienteIn, 
			SelectClienteIn selectClienteIn) {
		return new ClienteServiceImpl(createClienteIn, updateClienteIn, deleteClienteIn, selectClienteIn);
	}
}
