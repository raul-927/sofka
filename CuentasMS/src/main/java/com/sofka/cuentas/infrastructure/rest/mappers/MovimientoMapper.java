package com.sofka.cuentas.infrastructure.rest.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sofka.cuentas.domain.models.Movimiento;
import com.sofka.cuentas.infrastructure.entitys.MovimientoEntity;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {
	
	@Mappings({
        @Mapping(source = "movimientoId", 		target = "movimientoId"),
        @Mapping(source = "fecha", 		target = "fecha"),
        @Mapping(source = "tipoMovimiento", 	target = "tipoMovimiento"),
        @Mapping(source = "valor", 	target = "valor"),
        @Mapping(source = "saldo", 		target = "saldo"),
        @Mapping(source = "descripcionMovimiento", 		target = "descripcionMovimiento")
        })
		Movimiento toMovimiento(MovimientoEntity movimientoEntity);
		Iterable<Movimiento> tomovimientos(Iterable<MovimientoEntity> movimientoEntity);
		
		@InheritInverseConfiguration
		MovimientoEntity toMovimientoEnity (Movimiento movimiento);

}
