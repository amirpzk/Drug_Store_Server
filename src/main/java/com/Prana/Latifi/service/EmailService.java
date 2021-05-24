package com.Prana.Latifi.service;

public interface EmailService {
    void sendEmail(String from, String to, String subject, String content);

}
