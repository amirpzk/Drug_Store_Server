package com.Prana.Latifi.service.Impl;

import com.kavenegar.sdk.KavenegarApi;
import com.kavenegar.sdk.excepctions.ApiException;
import com.kavenegar.sdk.excepctions.HttpException;
import com.kavenegar.sdk.models.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SmsComponent {

    @Value("${sms-api-key}")
    private String smsApiKey;
    @Value("${sms-sender-name}")
    private String smsSender;
    private KavenegarApi api;
    @Autowired
    private Environment env;

    public SmsComponent(Environment env) {
        this.env = env;
    }

    @Async("sendSms")
    public SendResult sendMessage(String mobile, String message, String name) throws HttpException, ApiException {
        this.api = new KavenegarApi(env.getProperty("sms-api-key"));
        try {
            return api.verifyLookup(mobile, name, message, null, "Latifi-Verification");
        } catch (Exception e) {
        //    throw new WrongPhoneNumberException();
        }
        return null;
    }
}
