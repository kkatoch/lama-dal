package com.lama.dal.service;

import com.lama.dal.model.Email;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(Email email) {
        var mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email.getTo());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getMessage());
        mailMessage.setFrom(email.getFrom());
        javaMailSender.send(mailMessage);
    }
}