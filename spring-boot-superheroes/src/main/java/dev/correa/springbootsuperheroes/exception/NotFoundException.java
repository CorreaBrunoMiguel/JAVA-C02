package dev.correa.springbootsuperheroes.exception;

/**
 * Author: Bruno Miguel Correa
 * Email: devsistemascorrea@gmail.com
 * Data: 18/06/2025
 **/

public class NotFoundException extends RuntimeException {
	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NotFoundException(Throwable cause) {
		super(cause);
	}
}
