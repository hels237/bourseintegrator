package com._coder.bourse.service.impl;

import com._coder.bourse.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.verify.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String fromEmail;

    private final JavaMailSender mailSender ;

    @Override
    public void sendSimpleMailMessage(String senderName, String sendTo, String token) {

        try{

            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(" SOLICITATION : INTERESTED");
            message.setFrom(fromEmail);
            message.setTo(sendTo);
            message.setText("HEY I'M REALLY INTERESTED FOR YOUR PRODUCT");

            mailSender.send(message);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
