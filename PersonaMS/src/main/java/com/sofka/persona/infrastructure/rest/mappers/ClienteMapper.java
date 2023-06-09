package com.sofka.persona.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sofka.persona.domain.models.Cliente;
import com.sofka.persona.infrastructure.entitys.ClienteEntity;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	
	@Mappings({
        @Mapping(source = "clienteId", 		target = "clienteId"),
        @Mapping(source = "contrasenia", 	target = "contrasenia"),
        @Mapping(source = "estado", 		target = "estado"),
        @Mapping(source = "nombre", 		target = "nombre"),
        @Mapping(source = "genero", 		target = "genero"),
        @Mapping(source = "edad", 			target = "edad"),
        @Mapping(source = "identificacion", target = "identificacion"),
        @Mapping(source = "direccion", 		target = "direccion"),
        @Mapping(source = "telefono", 		target = "telefono")
        })
		Cliente toCliente(ClienteEntity clienteEntity);
		Iterable<Cliente> toClientes(Iterable<ClienteEntity> clienteEntity);
		
		@InheritInverseConfiguration
		ClienteEntity toClienteEnity (Cliente cliente);

}
