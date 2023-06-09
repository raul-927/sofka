package com.sofka.persona.infrastructure.exceptions;

public class ClienteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String 		message;
	private Throwable cause;
	
	public ClienteException() {}
	
	public ClienteException(String message) {
		super(message);
		this.message = message;
		
	}
	public ClienteException(String message, Throwable cause) {
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
