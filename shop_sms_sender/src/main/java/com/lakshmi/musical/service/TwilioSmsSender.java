package com.lakshmi.musical.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakshmi.musical.model.SmsRequest;
import com.lakshmi.musical.model.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSmsSender implements SmsSender {

	private final static Logger Logger = LoggerFactory.getLogger(TwilioSmsSender.class);

	@Autowired
	private TwilioConfiguration twilioConfiguration;

	@Override
	public void sendSms(SmsRequest smsRequest) {
		if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
			PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
			PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
			String body = smsRequest.getMessage(); 
			MessageCreator creator = Message.creator(to, from, body);
			creator.create();
			Logger.info ("Sent sms to {} ", smsRequest.getPhoneNumber());
		} else {
			throw new IllegalArgumentException("Please Enter the valid Phone Number");
		}
	}

	public boolean isPhoneNumberValid(String phoneNumber) {
		// phone number validation.
		//String regex = "(0/91)?[6-9][0-9]{9}";
		//return phoneNumber.matches(regex);
		
		//whatsapp number validation
		String regex = "(whatsapp:\\+91)[0-9]{10}";
		return phoneNumber.matches(regex);
	}
}
