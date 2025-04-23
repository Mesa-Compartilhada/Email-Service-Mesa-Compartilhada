package com.pi.mesacompartilhada_email_service.consumer;

import com.pi.mesacompartilhada_email_service.model.Email;
import com.pi.mesacompartilhada_email_service.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @Autowired
    final EmailService emailService;
    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listEmailQueue(@Payload Email email) {
        emailService.sendEmail(email);
    }

}
