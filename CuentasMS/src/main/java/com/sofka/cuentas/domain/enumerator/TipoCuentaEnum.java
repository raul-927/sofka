package com.sofka.cuentas.domain.enumerator;

public enum TipoCuentaEnum {
	
	DEBITO(1, "Débito"), CREDITO(2, "Crédito");
	
	
	private int id;
	private String descripcion;
	
	
	private TipoCuentaEnum(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	

}
