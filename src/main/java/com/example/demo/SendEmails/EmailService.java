package com.example.demo.SendEmails;

public interface EmailService {

    void sendSimpleEmail(String toEmail, String subject, String body);
}