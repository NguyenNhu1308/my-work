package com.example.demo.SendEmails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
public class EmailController {

    @Autowired private EmailService emailService;

    @PostMapping("/sendMail")
    public void sendMail(@QueryParam("toEmail") String toEmail,
                         @QueryParam("subject") String subject,
                         @QueryParam("body") String body) {

        emailService.sendSimpleEmail(toEmail, subject, body);
    }
}
