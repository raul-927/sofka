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


@Component
@EnableBinding({KafkaClienteProducer.class })
public class ClienteMessage {
	
	@Autowired
	@Qualifier(KafkaClienteProducer.CHANNELNAME)
	private MessageChannel output;
	
	
	
	public void sendClienteMessage(ClienteEntity cliente) {
			
		Map<String, Object> map = new HashMap<>();
		System.out.println("PARA ENVIAR Cliente: "+cliente.getNombre());
	    map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
	    MessageHeaders headers = new MessageHeaders(map);
	    GenericMessage<ClienteEntity> message = new GenericMessage<>(cliente,headers);
	    output.send(message);
		System.out.println("ENVIADO Cliente: "+message.getPayload());
	}
}
