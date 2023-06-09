package com.sofka.cuentas.infrastructure.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

@SuppressWarnings("deprecation")
public interface KafkaClienteConsumer {
	 String CHANNELNAME = "cliente-topic";
	 
	@Input(CHANNELNAME)
	MessageChannel subscriber();
}
