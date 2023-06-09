package com.sofka.cuentas.infrastructure.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.sofka.cuentas.domain.enumerator.GeneroEnum;


@MappedSuperclass
public abstract class PersonaViewEntity  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String 		nombre;
	
	@Enumerated(EnumType.STRING)
	private GeneroEnum 	genero;
	private Integer 	edad;
	
	@Column(name = "identificacion", unique = true)
	private int 		identificacion;
	private String 		direccion;
	private String 		telefono;
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public GeneroEnum getGenero() {
		return genero;
	}
	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public int getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
