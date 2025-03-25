package com.pi.mesacompartilhada_email_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

// classe para envio de emails
@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // pega o valor da variavel de ambiente do application.properties
    @Value(value="${SPRING_MAIL_USERNAME}")
    private String emailFrom;

    public void sendEmail(Email email) {
        var message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(email.to());
        message.setSubject(email.subject());
        message.setText(email.body());
        mailSender.send(message);
    }
}
