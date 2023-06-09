package com.sofka.persona.domain.enumerator;

public enum GeneroEnum {
	FEMENINO(1, "Femenino"),
	MASCULINO(2,"Masculino"),
	OTROS(3, "Otros");
	
	private int id;
	private String descripcion;
	
	
	private GeneroEnum(int id, String descripcion) {
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
