package com.sofka.cuentas.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sofka.cuentas.infrastructure.entitys.ClienteViewEntity;


@Repository
public interface ClienteRepository extends CrudRepository<ClienteViewEntity, Long> {

}
