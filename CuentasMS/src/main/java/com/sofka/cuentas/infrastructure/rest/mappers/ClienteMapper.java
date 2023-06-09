package com.sofka.cuentas.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sofka.cuentas.domain.models.Cliente;
import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.infrastructure.entitys.ClienteViewEntity;
import com.sofka.cuentas.infrastructure.entitys.CuentaEntity;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	
	@Mappings({
        @Mapping(source = "nombre", 		target = "nombre"),
        @Mapping(source = "genero", 		target = "genero"),
        @Mapping(source = "edad", 			target = "edad"),
        @Mapping(source = "identificacion", target = "identificacion"),
        @Mapping(source = "direccion", 		target = "direccion"),
        @Mapping(source = "telefono",		target = "telefono"),
        @Mapping(source = "clienteId",		target = "clienteId"),
        @Mapping(source = "contrasenia",	target = "contrasenia"),
        @Mapping(source = "estado",			target = "estado")
        })
		Cliente toCliente(ClienteViewEntity clienteEntity);
		Iterable<Cliente> toclientes(Iterable<ClienteViewEntity> clienteEntity);
		
		@InheritInverseConfiguration
		ClienteViewEntity toClienteEnity (Cliente cliente);

}
