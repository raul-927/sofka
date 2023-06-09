package com.sofka.cuentas.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.infrastructure.entitys.CuentaEntity;

@Mapper(componentModel = "spring")
public interface CuentaMapper {
	
	@Mappings({
        @Mapping(source = "cuentaId", 		target = "cuentaId"),
        @Mapping(source = "nroCuenta", 		target = "nroCuenta"),
        @Mapping(source = "tipoCuenta", 	target = "tipoCuenta"),
        @Mapping(source = "saldoInicial", 	target = "saldoInicial"),
        @Mapping(source = "estado", 		target = "estado")
        })
		Cuenta toCuenta(CuentaEntity cuentaEntity);
		Iterable<Cuenta> tocuentas(Iterable<CuentaEntity> cuentaEntity);
		
		@InheritInverseConfiguration
		CuentaEntity toCuentaEnity (Cuenta cuenta);

}
