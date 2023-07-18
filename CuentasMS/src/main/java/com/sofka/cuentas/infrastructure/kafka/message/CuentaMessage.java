package com.sofka.cuentas.infrastructure.kafka.message;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.sofka.cuentas.domain.enumerator.GeneroEnum;
import com.sofka.cuentas.domain.models.Cliente;
import com.sofka.cuentas.infrastructure.entitys.ClienteViewEntity;
import com.sofka.cuentas.infrastructure.entitys.CuentaEntity;
import com.sofka.cuentas.infrastructure.kafka.KafkaClienteConsumer;
import com.sofka.cuentas.infrastructure.kafka.KafkaCuentaProducer;
import com.sofka.cuentas.infrastructure.repository.ClienteRepository;
import com.sofka.cuentas.infrastructure.rest.mappers.ClienteMapper;
import com.sofka.utils.dto.MessageDto;
import com.sofka.utils.enumerator.EventEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@EnableBinding({KafkaClienteConsumer.class, KafkaCuentaProducer.class })
public class CuentaMessage {
	
	@Autowired
	@Qualifier(KafkaCuentaProducer.CHANNELNAME)
	private MessageChannel output;
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	ClienteMapper clienteMapper;
	
	@SuppressWarnings("deprecation")
	@StreamListener(value = KafkaClienteConsumer.CHANNELNAME, copyHeaders = "false")
	public void listenCuenta(Message<MessageDto<Cliente>> message) throws JsonProcessingException {
		Object cliObject = message.getPayload().getEntity();
		Cliente cliente = mapearLinkedHashMapCliente((Map)cliObject);
		EventEnum event = message.getPayload().getEvent();
		try {
			switch(event.name()) {
			case "INSERT":
				ClienteViewEntity clienteResult = clienteRepository.save(clienteMapper.toClienteEnity(cliente));
				break;
			case "UPDATE":
				Optional<ClienteViewEntity> clienteExist = clienteRepository.findById(cliente.getClienteId());
				if(clienteExist.isPresent()) {
					ClienteViewEntity clienteUpdate = clienteRepository.save(clienteMapper.toClienteEnity(cliente));
				}
				break;
			case "DELETE":
				Optional<ClienteViewEntity> clienteExistToDelete = clienteRepository.findById(cliente.getClienteId());
				if(clienteExistToDelete.isPresent()) {
					clienteRepository.delete(clienteExistToDelete.get());
				}
				break;
			}
			
        } catch (Exception e) {
            System.out.println("ERROR MESSAGE: "+e.getMessage());
            System.out.println("ERROR : "+e);
        }

	}
	
	private Cliente mapearLinkedHashMapCliente(Map map) {
		Cliente cliente = new Cliente();
		cliente.setNombre(map.get("nombre").toString());
		String genero = map.get("genero").toString();
		switch(genero) {
			case "MASCULINO":
				cliente.setGenero(GeneroEnum.MASCULINO);
				break;
			case "FEMENINO":
				cliente.setGenero(GeneroEnum.FEMENINO);
				break;
			case "OTROS":
				cliente.setGenero(GeneroEnum.OTROS);
				break;
		}
		cliente.setClienteId(Long.parseLong(map.get("clienteId").toString()));
		cliente.setEdad(Integer.parseInt(map.get("edad").toString()));
		cliente.setIdentificacion(Integer.parseInt(map.get("identificacion").toString()));
		cliente.setDireccion(map.get("direccion").toString());
		cliente.setTelefono(map.get("telefono").toString());
		cliente.setContrasenia(map.get("contrasenia").toString());
		boolean estado = map.get("estado").toString()=="true"? true:false;
		cliente.setEstado(estado);
		
		return cliente;
	}
}
