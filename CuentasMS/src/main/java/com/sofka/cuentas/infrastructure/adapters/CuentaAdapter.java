package com.sofka.cuentas.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sofka.cuentas.domain.models.Cuenta;
import com.sofka.cuentas.domain.ports.out.CuentaOut;
import com.sofka.cuentas.infrastructure.entitys.CuentaEntity;
import com.sofka.cuentas.infrastructure.exceptions.CuentaException;
import com.sofka.cuentas.infrastructure.repository.CuentaRepository;
import com.sofka.cuentas.infrastructure.rest.mappers.ClienteMapper;
import com.sofka.cuentas.infrastructure.rest.mappers.CuentaMapper;

@Component
public class CuentaAdapter implements CuentaOut {
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private CuentaMapper cuentaMapper;
	
	@Autowired
	private ClienteMapper clienteMapper;

	@Override
	public Cuenta createCuenta(Cuenta cuenta) {
		
		var clienteEntity = clienteMapper.toClienteEnity(cuenta.getCliente());
		var cuentaEntity = cuentaMapper.toCuentaEnity(cuenta);
		cuentaEntity.setCliente(clienteEntity);
		
		cuentaRepository.save(cuentaEntity);
		
		return cuentaMapper.toCuenta(cuentaRepository.save(cuentaEntity));
	}

	@Override
	public boolean deleteCuenta(Cuenta cuenta) {
		var cuentaEntity = cuentaMapper.toCuentaEnity(cuenta);
		var cuentaResult = cuentaRepository.findById(cuenta.getCuentaId()).orElseThrow(
				()-> new CuentaException("Cuenta no encontrada"));
		cuentaRepository.delete(cuentaEntity);
		return true;
	}

	@Override
	public List<Cuenta> selectAllCuentas() {
		var cuentas = cuentaMapper.tocuentas(cuentaRepository.findAll());
		return (List<Cuenta>) cuentas;
	}

	@Override
	public Cuenta selectCuenta(Cuenta cuenta) {
		var cuentaEntity = cuentaRepository.findById(cuenta.getCuentaId());
		return cuentaMapper.toCuenta(cuentaEntity.get());
	}

	@Override
	public Cuenta updateCuenta(Cuenta cuenta) {
		
		Optional<CuentaEntity> existCuenta = cuentaRepository.findById(cuenta.getCuentaId());

		if(existCuenta.isPresent()) {
			if(cuenta.getSaldoInicial()!=null) {
				existCuenta.get().setSaldoInicial(cuenta.getSaldoInicial());
			}
			existCuenta.get().setTipoCuenta(cuenta.getTipoCuenta());
			existCuenta.get().setEstado(cuenta.isEstado());
			var cuentaResult = cuentaRepository.save(existCuenta.get());
			return cuentaMapper.toCuenta(cuentaResult);
		}
		return null;
	}

}
