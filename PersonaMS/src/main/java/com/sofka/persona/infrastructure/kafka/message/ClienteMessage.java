package com.sofka.persona.infrastructure.kafka.message;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.sofka.persona.domain.models.Cliente;
import com.sofka.persona.infrastructure.entitys.ClienteEntity;
import com.sofka.persona.infrastructure.kafka.KafkaClienteProducer;
import com.sofka.utils.dto.MessageDto;
import com.sofka.utils.enumerator.EventEnum;


@Component
@EnableBinding({KafkaClienteProducer.class })
public class ClienteMessage {
	
	@Autowired
	@Qualifier(KafkaClienteProducer.CHANNELNAME)
	private MessageChannel output;
	
	
	
	public void sendClienteMessage(Cliente cliente) {
		MessageDto<Cliente> dto = new MessageDto(cliente, EventEnum.INSERT);
		Map<String, Object> map = new HashMap<>();
		System.out.println("PARA ENVIAR Cliente: "+cliente.getNombre());
	    map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
	    MessageHeaders headers = new MessageHeaders(map);
	    GenericMessage<MessageDto<Cliente>> message = new GenericMessage<>(dto,headers);
	    System.out.println("MESAGE ENVIADO: "+message.getPayload().getClass().getName());
	    output.send(message);
		System.out.println("ENVIADO Cliente: "+message.getPayload());
	}
	
	public void updateClienteMessage(ClienteEntity cliente) {
		MessageDto dto = new MessageDto(cliente, EventEnum.UPDATE);
		Map<String, Object> map = new HashMap<>();
		System.out.println("PARA Actualizar Cliente: "+cliente.getNombre());
	    map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
	    MessageHeaders headers = new MessageHeaders(map);
	    GenericMessage<MessageDto> message = new GenericMessage<>(dto,headers);
	    output.send(message);
		System.out.println("ENVIADO Cliente: "+message.getPayload());
	}
}
