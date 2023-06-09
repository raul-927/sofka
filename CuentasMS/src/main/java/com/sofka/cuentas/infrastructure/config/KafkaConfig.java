package com.sofka.cuentas.infrastructure.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import com.sofka.cuentas.infrastructure.kafka.KafkaClienteConsumer;
import com.sofka.cuentas.infrastructure.kafka.KafkaCuentaProducer;


@EnableBinding({KafkaClienteConsumer.class, KafkaCuentaProducer.class })
@Configuration
public class KafkaConfig {
	
	
	
	@Bean
	public NewTopic javaguidesTopic(){
        return TopicBuilder.name("cuenta-topic")
                .build();
    }

}
