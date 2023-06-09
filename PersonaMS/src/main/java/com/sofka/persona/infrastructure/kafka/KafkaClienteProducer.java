package com.sofka.persona.infrastructure.kafka;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@SuppressWarnings("deprecation")
public interface KafkaClienteProducer {
	
	String CHANNELNAME = "binding-out-cliente";
	String CHANNELNAME2 = "binding-in-cliente";
	
	 @Output(CHANNELNAME)
	    MessageChannel output();
	 
	 @Input(CHANNELNAME2)
		MessageChannel subscriber();
}
