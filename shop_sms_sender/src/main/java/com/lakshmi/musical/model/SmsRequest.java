package com.lakshmi.musical.model;

import javax.validation.constraints.NotBlank;

public class SmsRequest {

	@NotBlank
	private String phoneNumber;
	@NotBlank
	private String message;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "SmsRequest [phoneNumber=" + phoneNumber + ", message=" + message + "]";
	}
}
