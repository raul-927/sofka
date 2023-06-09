package com.sofka.cuentas.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sofka.cuentas.infrastructure.entitys.MovimientoEntity;

@Repository
public interface MovimientoRepository extends CrudRepository<MovimientoEntity, Long> {
	
	@Query(value = "SELECT \n"
			+ "	m.fecha, \n"
			+ "	m.tipo_movimiento, \n"
			+ "	m.valor, \n"
			+ "	c.nro_cuenta,\n"
			+ "	c.tipo_cuenta, \n"
			+ "	c.saldo_inicial, \n"
			+ "	cv.nombre\n"
			+ "FROM movimientos m\n"
			+ "INNER JOIN cuenta c on c.cuenta_id  = m.cuenta_cuenta_id \n"
			+ "INNER JOIN clientes_view cv on cv.cliente_id = c.cliente_cliente_id\n"
			+ "WHERE cv.identificacion = :identificacion"
			+ "AND m.fecha BETWEEN :fechaInicial AND :fechaFinal", nativeQuery = true)
	List<MovimientoEntity> findMovimientoByFechaAndCliente(String fechaInicial, String fechaFinal, int identificacion);
}
