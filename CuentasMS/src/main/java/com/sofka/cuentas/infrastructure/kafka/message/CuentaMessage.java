package com.sofka.cuentas.infrastructure.kafka.message;

import java.util.HashMap;
import java.util.Map;

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

import com.sofka.cuentas.infrastructure.entitys.ClienteViewEntity;
import com.sofka.cuentas.infrastructure.entitys.CuentaEntity;
import com.sofka.cuentas.infrastructure.kafka.KafkaClienteConsumer;
import com.sofka.cuentas.infrastructure.kafka.KafkaCuentaProducer;
import com.sofka.cuentas.infrastructure.repository.ClienteRepository;

@Component
@EnableBinding({KafkaClienteConsumer.class, KafkaCuentaProducer.class })
public class CuentaMessage {
	
	@Autowired
	@Qualifier(KafkaCuentaProducer.CHANNELNAME)
	private MessageChannel output;
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@SuppressWarnings("deprecation")
	@StreamListener(value = KafkaClienteConsumer.CHANNELNAME, copyHeaders = "false")
	public void listenCuenta(Message<ClienteViewEntity> message) {
		ClienteViewEntity cli = message.getPayload();
		
		try {
			
			ClienteViewEntity cuentaResult = clienteRepository.save(cli);
			
			
        } catch (Exception e) {
            System.out.println("ERROR MESSAGE: "+e.getMessage());
            System.out.println("ERROR : "+e);
        }

	}
}
