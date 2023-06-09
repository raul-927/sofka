package com.sofka.cuentas.infrastructure.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface KafkaClienteConsumer {
	 String CHANNELNAME = "binding-in-department";
	 
	@Input(CHANNELNAME)
	MessageChannel subscriber();
}
