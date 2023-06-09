package com.sofka.cuentas.infrastructure.entitys;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sofka.cuentas.domain.enumerator.TipoCuentaEnum;


@Entity
@Table(name="cuenta")
public class CuentaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long 			cuentaId;
	private Long 			nroCuenta;
	@Enumerated(EnumType.STRING)
	private TipoCuentaEnum 	tipoCuenta;
	private BigDecimal 		saldoInicial;
	
	@OneToOne
	private ClienteViewEntity cliente;
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
	public ClienteViewEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteViewEntity cliente) {
		this.cliente = cliente;
	}

}
