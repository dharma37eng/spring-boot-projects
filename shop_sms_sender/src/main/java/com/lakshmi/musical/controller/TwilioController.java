package com.lakshmi.musical.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lakshmi.musical.model.SmsRequest;
import com.lakshmi.musical.service.SmsSender;

@RestController
@RequestMapping("/api/v1/sms")
public class TwilioController {

	@Autowired
	private SmsSender smsSender;

	@PostMapping
	public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
		smsSender.sendSms(smsRequest);
	}
}
