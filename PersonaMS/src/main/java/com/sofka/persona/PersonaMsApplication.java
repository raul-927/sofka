package com.sofka.persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.sofka.persona.infrastructure.entitys") 
public class PersonaMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonaMsApplication.class, args);
	}

}
