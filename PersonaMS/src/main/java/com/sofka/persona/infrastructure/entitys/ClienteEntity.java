package com.sofka.persona.infrastructure.entitys;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sofka.persona.infrastructure.messageerror.ClienteErrorMessage;

import javax.persistence.*;




@Entity
@Table(name ="cliente")
public class ClienteEntity extends PersonaEntity{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long 	clienteId;
	
	@NotNull(message = ClienteErrorMessage.CONTRASENIA_NOT_NULL)
	@Size(min =3, max = 20, message =ClienteErrorMessage.CONTRASENIA_SIZE)
	private String 	contrasenia;
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
