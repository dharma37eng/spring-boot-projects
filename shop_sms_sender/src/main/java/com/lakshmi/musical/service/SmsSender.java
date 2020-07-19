package com.lakshmi.musical.service;

import com.lakshmi.musical.model.SmsRequest;

public interface SmsSender {
	
	void sendSms(SmsRequest smsRequest);

}
