package com.infy.exception;

public class ContactNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8600366145977713698L;
	private String message;
	public ContactNotFoundException(String message) {
		super();
		this.message = message;
	}
	public ContactNotFoundException() {}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ContactNotFoundException [message=" + message + "]";
	}


}
