package com.sofka.cuentas.infrastructure.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Immutable;

import com.sofka.cuentas.infrastructure.messageerror.ClienteErrorMessage;

@Entity(name = "clientes_view")
@Immutable
public class ClienteViewEntity extends PersonaViewEntity{
	
private static final long serialVersionUID = 1L;
	
	@Id
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
