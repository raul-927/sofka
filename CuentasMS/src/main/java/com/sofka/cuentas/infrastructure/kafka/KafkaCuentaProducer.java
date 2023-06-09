package com.sofka.cuentas.infrastructure.kafka;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaCuentaProducer {
	String CHANNELNAME = "binding-out-city";

    @Output(CHANNELNAME)
    MessageChannel output();

}
