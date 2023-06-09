package com.sofka.persona.domain.models;


public class Cliente extends Persona{

	private static final long serialVersionUID = 1L;
	
	private Long clienteId;
	private String contrasenia;
	private boolean estado;
	
	
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
