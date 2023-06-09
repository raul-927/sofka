package com.sofka.cuentas.infrastructure.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sofka.cuentas.domain.enumerator.TipoCuentaEnum;

@Entity
@Table(name ="movimientos")
public class MovimientoEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movimientoId;
	
	//@JsonFormat(pattern="dd/MM/yyyy")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate fecha;
	
	@Enumerated(EnumType.STRING)
	private TipoCuentaEnum tipoMovimiento;
	private BigDecimal valor;
	private BigDecimal saldo;
	private String descripcionMovimiento;
	
	@OneToOne
	private CuentaEntity cuenta;
	
	
	public CuentaEntity getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaEntity cuenta) {
		this.cuenta = cuenta;
	}
	public int getMovimientoId() {
		return movimientoId;
	}
	public void setMovimientoId(int movimientoId) {
		this.movimientoId = movimientoId;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public TipoCuentaEnum getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(TipoCuentaEnum tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public String getDescripcionMovimiento() {
		return descripcionMovimiento;
	}
	public void setDescripcionMovimiento(String descripcionMovimiento) {
		this.descripcionMovimiento = descripcionMovimiento;
	}

}
