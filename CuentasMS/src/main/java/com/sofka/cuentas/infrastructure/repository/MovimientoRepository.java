package com.sofka.cuentas.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sofka.cuentas.infrastructure.entitys.MovimientoEntity;

@Repository
public interface MovimientoRepository extends CrudRepository<MovimientoEntity, Long> {

}
