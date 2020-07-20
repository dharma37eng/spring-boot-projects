package com.lakshmi.musical.service;

public class EncryptionDecryptionTest {

	public static void main(String args []) throws Exception
	{
		EncryptionDecryptionImpl td= new EncryptionDecryptionImpl();

		String target="";
		String encrypted=td.encrypt(target);
		String decrypted=td.decrypt(encrypted);

		System.out.println("String To Encrypt: "+ target);
		System.out.println("Encrypted String:" + encrypted);
		System.out.println("Decrypted String:" + decrypted);

	}

}
