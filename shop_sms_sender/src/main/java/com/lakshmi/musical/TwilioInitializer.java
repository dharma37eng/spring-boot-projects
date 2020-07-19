package com.lakshmi.musical;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lakshmi.musical.model.TwilioConfiguration;
import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {

	private final static Logger Logger = LoggerFactory.getLogger(TwilioInitializer.class);

	@Autowired
	private TwilioConfiguration twilioConfiguration;

	@Bean
	public void twilioInit() {
		Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());
		Logger.info("Twilio initialized with account sid {} ", twilioConfiguration.getAccountSid());
	}

}
