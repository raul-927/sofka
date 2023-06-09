package com.sofka.persona.infrastructure.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.apache.kafka.clients.admin.NewTopic;

import com.sofka.persona.infrastructure.kafka.KafkaClienteProducer;

@EnableBinding({KafkaClienteProducer.class })
@Configuration
public class WebConfig {
	
	
	@Bean
	public NewTopic javaguidesTopic(){
        return TopicBuilder.name("cliente-topic")
                .build();
    }

}
