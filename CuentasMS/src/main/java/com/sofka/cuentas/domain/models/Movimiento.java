package com.sofka.cuentas.domain.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import com.sofka.cuentas.domain.enumerator.TipoCuentaEnum;

public class Movimiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int movimientoId;
	private LocalDate fecha;
	private TipoCuentaEnum tipoMovimiento;
	private BigDecimal valor;
	private BigDecimal saldo;
	private String descripcionMovimiento;
	private Cuenta cuenta;
	
	
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
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}
