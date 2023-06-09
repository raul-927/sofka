package com.sofka.cuentas.domain.models;

import java.io.Serializable;
import java.math.BigDecimal;

import com.sofka.cuentas.domain.enumerator.TipoCuentaEnum;

public class Cuenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long 			cuentaId;
	private Long 			nroCuenta;
	private TipoCuentaEnum 	tipoCuenta;
	private BigDecimal 		saldoInicial;
	private Cliente 		cliente;
	private boolean 		estado;
	
	public Long getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(Long cuentaId) {
		this.cuentaId = cuentaId;
	}
	public Long getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(Long nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public TipoCuentaEnum getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(TipoCuentaEnum tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
