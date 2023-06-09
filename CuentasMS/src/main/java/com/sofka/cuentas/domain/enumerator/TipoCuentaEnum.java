package com.sofka.cuentas.domain.enumerator;

public enum TipoCuentaEnum {
	
	AHORRO(1, "Ahorro"), CORRIENTE(2, "Corriente");
	
	
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
