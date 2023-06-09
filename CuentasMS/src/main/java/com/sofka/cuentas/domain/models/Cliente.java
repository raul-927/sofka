package com.sofka.cuentas.domain.models;

import com.sofka.cuentas.domain.enumerator.GeneroEnum;

public class Cliente {
	
	private String 		nombre;
	private GeneroEnum 	genero;
	private Integer 	edad;
	private int 		identificacion;
	private String 		direccion;
	private String 		telefono;
	private Long 		clienteId;
	private String 	contrasenia;
	private boolean estado;
	
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
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
