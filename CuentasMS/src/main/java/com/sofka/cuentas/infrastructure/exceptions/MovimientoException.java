package com.sofka.cuentas.infrastructure.exceptions;

public class MovimientoException extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	private String 		message;
	private Throwable cause;
	
	public MovimientoException() {}
	
	public MovimientoException(String message) {
		super(message);
		this.message = message;
		
	}
	public MovimientoException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.cause = cause;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the cause
	 */
	public Throwable getCause() {
		return cause;
	}

}
