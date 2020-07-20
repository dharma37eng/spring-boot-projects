package com.lakshmi.musical.service;

public interface EncryptionDecryption {

	public String encrypt(String unencryptedString);

	public String decrypt(String encryptedString);

}
